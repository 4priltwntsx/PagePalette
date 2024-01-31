package com.ktds.pagepalette.service;

import com.ktds.pagepalette.entity.Card;

import java.util.ArrayList;

public interface CardService {
    public Long createCard();
    public ArrayList<Card> readAll();
    public Card readDetail();
    public Long modifyCard();
    public Boolean deleteCard();
}
