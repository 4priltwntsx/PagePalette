package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.user.UserJoinReq;
import com.ktds.pagepalette.dto.user.UserLoginReq;
import com.ktds.pagepalette.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public String login(UserLoginReq userLoginReq) {

        return null;
    }

    @Override
    public boolean join(UserJoinReq userJoinReq) {
        return false;
    }
}
