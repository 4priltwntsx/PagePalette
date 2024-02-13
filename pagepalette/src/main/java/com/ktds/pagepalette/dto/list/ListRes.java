package com.ktds.pagepalette.dto.list;

import com.ktds.pagepalette.dto.card.CardRes;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ListRes {
    Long listId;
    String bookTitle;
    String bookIsbn;
    ArrayList<CardRes> cards;
    @Builder
    public ListRes(Long listId, String bookIsbn, String bookTitle, ArrayList<CardRes> cards) {
        this.listId = listId;
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.cards = cards;
    }
}
