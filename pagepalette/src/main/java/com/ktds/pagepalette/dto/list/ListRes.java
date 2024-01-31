package com.ktds.pagepalette.dto.list;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ListRes {
    Long listId;
    String bookTitle;

    @Builder
    public ListRes(Long listId, String bookTitle) {
        this.listId = listId;
        this.bookTitle = bookTitle;
    }
}
