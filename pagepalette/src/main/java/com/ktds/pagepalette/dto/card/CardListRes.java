package com.ktds.pagepalette.dto.card;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CardListRes {
    private String description;
    private Double pos;
    private String bgColor;

    public CardListRes(String description, Double pos, String bgColor) {
        this.description = description;
        this.pos = pos;
        this.bgColor = bgColor;
    }
}