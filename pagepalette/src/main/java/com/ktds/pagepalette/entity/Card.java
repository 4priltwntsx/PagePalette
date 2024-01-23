package com.ktds.pagepalette.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "card")
public class Card extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double pos;
    private String bgColor;

//    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
    @ManyToOne(targetEntity = List.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    private List list;
}
