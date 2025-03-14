package com.ktds.pagepalette.dto.card;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class CardReq {
    private String title;
    private String description;
    private Double pos;
    private String bgColor;
    private Long listId;
}
