package com.ktds.pagepalette.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    @ColumnDefault("65535")
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
    @ColumnDefault("true")
    private Boolean isActive;


    @Builder
    public Card(Long id, String title, String description, Double pos, String bgColor, List list, Boolean isActive) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pos = pos;
        this.bgColor = bgColor;
        this.list = list;
        this.isActive = isActive;
    }

    public void updateCardInfo(String title, String description, Double pos, String bgColor){
        this.title = title;
        this.description = description;
        this.pos = pos;
        this.bgColor = bgColor;
    }

    public Boolean deleteCard(){
        this.isActive = false;
        return true;
    }


}
