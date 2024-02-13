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

    @ManyToOne(targetEntity = Board.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_isbn")
    private Book book;

    @ColumnDefault("true")
    private Boolean isActive;

    @Builder
    public List(Long id, Board board, Boolean isActive, Book book) {
        this.id = id;
        this.board = board;
        this.isActive = isActive;
        this.book = book;
    }


    public void deleteList(){
        this.isActive = false;
    }
}
