package com.ktds.pagepalette.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "book")
public class Book {
    @Id
    private String bookIsbn;
    private String bookTitle;
    private String bookPublisher;
    private int bookPrice;
    private String bookDescription;
    private String bookImage;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;
}
