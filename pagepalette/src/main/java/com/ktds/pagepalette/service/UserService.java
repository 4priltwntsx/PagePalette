package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.user.UserJoinReq;
import com.ktds.pagepalette.dto.user.UserLoginReq;

public interface UserService {
    public boolean login(UserLoginReq userLoginReq);
    public boolean join(UserJoinReq userJoinReq);
    public boolean checkEmail(String email);
}
