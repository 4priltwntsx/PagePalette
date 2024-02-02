package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.card.CardModifyReq;
import com.ktds.pagepalette.dto.card.CardReq;
import com.ktds.pagepalette.dto.card.CardRes;
import com.ktds.pagepalette.entity.Card;

import java.util.ArrayList;

public interface CardService {
    public Long createCard(CardReq request);
    public ArrayList<CardRes> readAll(Long listId);
    public CardRes readDetail(Long cardId);
    public Long modifyCard(CardModifyReq request);
    public Boolean deleteCard(Long cardId);
}
