package com.ktds.pagepalette.service;

import com.ktds.pagepalette.entity.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CardServiceImpl implements CardService{
    @Override
    public Long createCard() {
        return null;
    }

    @Override
    public ArrayList<Card> readAll() {
        return null;
    }

    @Override
    public Card readDetail() {
        return null;
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
