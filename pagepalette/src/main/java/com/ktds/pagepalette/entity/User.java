package com.ktds.pagepalette.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name="user")
public class User extends Time{

    @Id
    private String id;
    private String email;
    private String name;
    private String password;

}
