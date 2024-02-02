package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.card.CardReq;
import com.ktds.pagepalette.dto.card.CardRes;
import com.ktds.pagepalette.entity.Card;

import java.util.ArrayList;

public interface CardService {
    public Long createCard(CardReq req);
    public ArrayList<CardRes> readAll(Long list_id);
    public CardRes readDetail(Long cardId);
    public Long modifyCard();
    public Boolean deleteCard();
}
