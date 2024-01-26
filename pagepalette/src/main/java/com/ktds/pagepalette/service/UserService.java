package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.user.UserJoinReq;
import com.ktds.pagepalette.dto.user.UserLoginReq;
import com.ktds.pagepalette.dto.user.UserLoginRes;

import java.util.HashMap;
import java.util.Optional;

public interface UserService {
    public Optional<UserLoginRes> login(UserLoginReq userLoginReq);
    public boolean join(UserJoinReq userJoinReq);
    public boolean checkEmail(String email);
}
