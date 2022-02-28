package com.sparta.minicommunity.controller;

import com.sparta.minicommunity.dto.requestDto.LoginCheckDto;
import com.sparta.minicommunity.dto.responseDto.LoginResponseDto;
import com.sparta.minicommunity.dto.requestDto.RegisterDto;
import com.sparta.minicommunity.dto.responseDto.ResponseDto;
import com.sparta.minicommunity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://spartaweek2-25f73.firebaseapp.com/")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/register")
    public ResponseDto userRegister(@RequestBody RegisterDto registerDto) {
        System.out.println(registerDto);
        return userService.registerCheck(registerDto);
    }

    @PostMapping("/api/login")
    public LoginResponseDto login(@RequestBody LoginCheckDto loginCheckDto) {
        return userService.loginCheck(loginCheckDto);
    }
//    @PostMapping("/api/logout")
//    public ResponseDto logout (HttpSession session) {
//        ResponseDto responseDto = new ResponseDto();
//        session.invalidate();
//        responseDto.setResult(true);
//        responseDto.setMsg("로그아웃");
//        return responseDto;
//    }
}
