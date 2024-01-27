package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.dto.user.UserJoinReq;
import com.ktds.pagepalette.dto.user.UserLoginReq;
import com.ktds.pagepalette.dto.user.UserLoginRes;
import com.ktds.pagepalette.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserJoinReq request) throws Exception {
        return new ResponseEntity<>(userService.join(request), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginReq request) throws Exception {
        Optional<UserLoginRes> response = userService.login(request);
        if (response.isEmpty()) {
            return new ResponseEntity<>("login fail", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(response.get(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkEmail(@RequestParam("email") String email) {
        return new ResponseEntity<>(userService.checkEmail(email), HttpStatus.ACCEPTED);
    }
}
