package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.user.UserJoinReq;
import com.ktds.pagepalette.dto.user.UserLoginReq;
import com.ktds.pagepalette.dto.user.UserLoginRes;
import com.ktds.pagepalette.entity.User;
import com.ktds.pagepalette.exception.NotFoundException;
import com.ktds.pagepalette.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final String MESSAGE = "존재하지 않는 사용자입니다!";


    @Override
    public Optional<UserLoginRes> login(UserLoginReq userLoginReq) {
        Optional<User> user = userRepository.findById(userLoginReq.getEmail());
        return user.map(value -> new UserLoginRes(value.getEmail(), value.getName()));
    }

    @Override
    @Transactional(readOnly=false)
    public boolean join(UserJoinReq userJoinReq) {
        userRepository.saveAndFlush(new User(userJoinReq.getEmail(), userJoinReq.getName(), userJoinReq.getPassword()));
        return true;
    }

    @Override
    public boolean checkEmail(String email) {
        Optional<User> user = userRepository.findById(email);
        return user.isEmpty(); // 이미 존재하는 이메일 : false, 사용가능: true
    }
}
