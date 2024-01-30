package com.ktds.pagepalette.dto.board;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardReq {
    String title;
    String bgColor;
    String userEmail;
    Long id;

}
