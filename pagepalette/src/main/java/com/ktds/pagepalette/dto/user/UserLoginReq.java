package com.ktds.pagepalette.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginReq {
    private String email;
    private String password;
}
