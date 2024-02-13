package com.ktds.pagepalette.dto.book;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookInfoRes {
    private String bookTitle;
    private String bookIsbn;
    private String authorName;
    //    private Long authorId;
    private String bookImage;
    private String bookDescription;
}
