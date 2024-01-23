package com.ktds.pagepalette.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "list")
public class List extends Time
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
    @ManyToOne(targetEntity = Board.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;
    private Boolean isActive;
    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_isbn")
    private String bookIsbn;
}
