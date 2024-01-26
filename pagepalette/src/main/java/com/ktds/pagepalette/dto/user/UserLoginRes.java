package com.ktds.pagepalette.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRes {
    private String email;
    private String name;

    public UserLoginRes(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
