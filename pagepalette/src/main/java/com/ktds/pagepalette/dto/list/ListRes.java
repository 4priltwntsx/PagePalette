package com.ktds.pagepalette.dto.list;

import com.ktds.pagepalette.dto.card.CardRes;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ListRes {
    Long listId;
    String bookTitle;
    ArrayList<CardRes> cards;
    @Builder
    public ListRes(Long listId, String bookTitle, ArrayList<CardRes> cards) {
        this.listId = listId;
        this.bookTitle = bookTitle;
        this.cards = cards;
    }
}
