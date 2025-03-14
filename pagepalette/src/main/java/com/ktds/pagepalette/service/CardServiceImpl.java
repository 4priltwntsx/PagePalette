package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.card.CardModifyReq;
import com.ktds.pagepalette.dto.card.CardPosReq;
import com.ktds.pagepalette.dto.card.CardReq;
import com.ktds.pagepalette.dto.card.CardRes;
import com.ktds.pagepalette.entity.Card;
import com.ktds.pagepalette.entity.List;
import com.ktds.pagepalette.exception.NotFoundException;
import com.ktds.pagepalette.repository.CardRepository;
import com.ktds.pagepalette.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CardServiceImpl implements CardService {

    private final ListRepository listRepository;
    private final CardRepository cardRepository;

    @Override
    @Transactional
    public Long createCard(CardReq request) {
        Optional<List> optionalList = listRepository.findById(request.getListId());

        if (optionalList.isEmpty()) {
            throw new NotFoundException("존재하지 않는 리스트 아이디!");
        }
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Card card = Card.builder().isActive(true)
                .list(optionalList.get())
                .title(request.getTitle())
                .pos(request.getPos()).description(request.getDescription()).bgColor(request.getBgColor())
                .build();
        cardRepository.save(card);

        return optionalList.get().getId();

    }

    @Override
    public ArrayList<CardRes> readAll(Long listId) {
        Optional<List> optionalList = listRepository.findById(listId);

        if (optionalList.isEmpty()) {
            throw new NotFoundException("존재하지 않는 리스트 아이디!");
        }
        return cardRepository.findCardsByListId(listId);
    }

    @Override
    public CardRes readDetail(Long cardId) {
        Optional<Card> optionalCard = cardRepository.findById(cardId);
        if(optionalCard.isEmpty()){
            throw new NotFoundException("존재하지 않는 카드 아이디");
        }
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(false);
        return new ModelMapper().map(optionalCard.get(), CardRes.class);
    }

    @Override
    @Transactional
    public Long modifyCard(CardModifyReq request) {
        Optional<Card> optionalCard = cardRepository.findById(request.getCardId());
        if(optionalCard.isEmpty()){
            throw new NotFoundException("존재하지 않는 카드 아이디");
        }
        Card card = optionalCard.get();
        card.updateCardInfo(request.getTitle(), request.getDescription(), request.getPos(), request.getBgColor());
        return cardRepository.save(card).getId();
    }

    @Override
    @Transactional
    public Long modifyCardPos(CardPosReq request) {
        Optional<Card> optionalCard = cardRepository.findById(request.getCardId());
        if(optionalCard.isEmpty()){
            throw new NotFoundException("존재하지 않는 카드 아이디");
        }
        Card card = optionalCard.get();
        System.out.println(cardRepository.updatePos(request.getPos(), request.getCardId()));
        return card.getId();
    }

    @Override
    @Transactional
    public Boolean deleteCard(Long cardId) {
        Optional<Card> optionalCard = cardRepository.findById(cardId);
        if(optionalCard.isEmpty()){
            throw new NotFoundException("존재하지 않는 카드 아이디");
        }
        Card card = optionalCard.get();
        if(card.deleteCard()){
            return true;
        }
        return false;
    }
}
