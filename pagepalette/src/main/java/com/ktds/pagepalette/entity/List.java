package com.ktds.pagepalette.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Getter
@Entity
@NoArgsConstructor
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
    @ColumnDefault("true")
    private Boolean isActive;
//    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "book_isbn")
    private String bookIsbn;
    private String bookTitle;


    @Builder
    public List(Long id, Board board, Boolean isActive, String bookTitle, String bookIsbn) {
        this.id = id;
        this.board = board;
        this.isActive = isActive;
        this.bookTitle = bookTitle;
        this.bookIsbn = bookIsbn;
    }

    public void updateListInfo(String title){
        this.bookTitle = title;
    }
}
