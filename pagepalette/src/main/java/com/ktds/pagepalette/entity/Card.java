package com.ktds.pagepalette.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "card")
@ToString
@NoArgsConstructor
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
//    @ManyToOne(targetEntity = Board.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    private Board board;
    private Boolean isActive;


    @Builder
    public Card(Long id, String title, String description, Double pos, String bgColor, List list) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pos = pos;
        this.bgColor = bgColor;
        this.list = list;
    }

    public void updateCardInfo(String description, Double pos, String bgColor){
        this.description = description;
        this.pos = pos;
        this.bgColor = bgColor;
    }

    public Boolean deleteCard(){
        this.isActive = false;
        return true;
    }


}
