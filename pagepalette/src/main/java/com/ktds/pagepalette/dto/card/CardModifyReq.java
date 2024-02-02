package com.ktds.pagepalette.dto.card;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CardModifyReq{
    private String title;
    private String description;
    private Double pos;
    private String bgColor;
    private Long cardId;
}
