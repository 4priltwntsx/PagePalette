package com.ktds.pagepalette.dto.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListModifyReq {
    Long listId;
    String bookTitle;
}