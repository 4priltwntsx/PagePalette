package com.ktds.pagepalette.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "board")
public class Board extends Time{
    @Id
    private Long id;
    private String title;
    private String bgColor;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private Boolean isActive;
}
