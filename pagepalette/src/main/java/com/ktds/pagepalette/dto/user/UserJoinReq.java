package com.ktds.pagepalette.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserJoinReq {

    private String email;
    private String name;
    private String password;
    public UserJoinReq(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
