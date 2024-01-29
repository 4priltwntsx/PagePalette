package com.ktds.pagepalette.dto.board;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardReadRes {
    Long boardId;
    String title;
    String bgColor;
    String userEmail;

    @Builder
    public BoardReadRes(Long boardId, String title, String bgColor, String userEmail) {
        this.boardId = boardId;
        this.title = title;
        this.bgColor = bgColor;
        this.userEmail = userEmail;
    }
}
