package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.dto.user.UserJoinReq;
import com.ktds.pagepalette.dto.user.UserLoginReq;
import com.ktds.pagepalette.dto.user.UserLoginRes;
import com.ktds.pagepalette.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> join(@RequestBody UserJoinReq request) throws Exception {
        return new ResponseEntity<>(userService.join(request), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginReq request) throws Exception {
        Optional<UserLoginRes> response = userService.login(request);
        if(response.isEmpty()){
            return new ResponseEntity<>("login fail", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(response.get(), HttpStatus.ACCEPTED);
    }


}
