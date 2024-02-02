package com.ktds.pagepalette.service;

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
        Card card = new ModelMapper().map(request, Card.class);
        card.setList(optionalList.get());

        return cardRepository.save(card).getList().getId();

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
    public Long modifyCard() {
        return null;
    }

    @Override
    public Boolean deleteCard() {
        return null;
    }
}
