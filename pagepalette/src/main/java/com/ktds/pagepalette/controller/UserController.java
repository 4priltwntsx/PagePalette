package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.dto.user.UserJoinReq;
import com.ktds.pagepalette.dto.user.UserLoginReq;
import com.ktds.pagepalette.dto.user.UserLoginRes;
import com.ktds.pagepalette.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
@Tag(name = "유저 API(UserController)")
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    @Operation(summary = "회원가입")
    public ResponseEntity<?> join(@RequestBody UserJoinReq request) throws Exception {
        return new ResponseEntity<>(userService.join(request), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public ResponseEntity<?> login(@RequestBody UserLoginReq request) throws Exception {
        Optional<UserLoginRes> response = userService.login(request);
        if (response.isEmpty()) {
            return new ResponseEntity<>("login fail", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(response.get(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/check")
    @Operation(summary = "이메일 중복 체크")
    public ResponseEntity<?> checkEmail(@RequestParam("email") String email) {
        return new ResponseEntity<>(userService.checkEmail(email), HttpStatus.ACCEPTED);
    }
}
