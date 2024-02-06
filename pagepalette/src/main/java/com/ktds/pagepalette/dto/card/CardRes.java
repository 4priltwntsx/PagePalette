package com.ktds.pagepalette.dto.card;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CardRes {
    private String description;
    private Double pos;
    private String bgColor;
    private Long cardId;
    private String title;
    @Builder
    public CardRes(String description, Double pos, String bgColor, Long cardId, String title) {
        this.description = description;
        this.pos = pos;
        this.bgColor = bgColor;
        this.cardId = cardId;
        this.title = title;
    }
}