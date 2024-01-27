package com.ktds.pagepalette.dto.board;

import lombok.Getter;

@Getter
public class BoardReq {
    String title;
    String bgColor;
    String userEmail;

    public BoardReq(String title, String bgColor) {
        this.title = title;
        this.bgColor = bgColor;
    }
}
