package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.user.UserJoinReq;
import com.ktds.pagepalette.dto.user.UserLoginReq;

public interface UserService {
    public String login(UserLoginReq userLoginReq);
    public boolean join(UserJoinReq userJoinReq);
}
