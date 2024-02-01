package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.card.CardListRes;
import com.ktds.pagepalette.dto.card.CardReq;
import com.ktds.pagepalette.entity.Card;

import java.util.ArrayList;

public interface CardService {
    public Long createCard(CardReq req);
    public ArrayList<CardListRes> readAll(Long list_id);
    public Card readDetail();
    public Long modifyCard();
    public Boolean deleteCard();
}
