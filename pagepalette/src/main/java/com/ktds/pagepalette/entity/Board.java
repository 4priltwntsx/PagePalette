package com.ktds.pagepalette.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Table(name = "board")
@NoArgsConstructor
public class Board extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ColumnDefault("4682B4")
    private String bgColor;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email")
    private User user;
    @ColumnDefault("true")
    private Boolean isActive;

    @Builder
    public Board(String title, String bgColor, User user, Boolean isActive) {
        this.title = title;
        this.bgColor = bgColor;
        this.user = user;
        this.isActive = isActive;
    }

    public void update(String title, String bgColor){
        this.title = title;
        this.bgColor = bgColor;
    }

    public void delete(){
        this.isActive = false;
    }
}
