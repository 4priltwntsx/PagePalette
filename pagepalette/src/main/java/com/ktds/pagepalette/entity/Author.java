package com.ktds.pagepalette.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="author")
public class Author {
    @Id
    private Long authorId;
    private String authorName;
}