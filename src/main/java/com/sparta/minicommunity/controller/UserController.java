package com.sparta.minicommunity.controller;

import com.sparta.minicommunity.dto.LoginCheckDto;
import com.sparta.minicommunity.dto.LoginResponseDto;
import com.sparta.minicommunity.dto.RegisterDto;
import com.sparta.minicommunity.dto.ResponseDto;
import com.sparta.minicommunity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "https://spartaweek2-25f73.firebaseapp.com/")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/register")
    public ResponseDto userRegister(@RequestBody RegisterDto registerDto, HttpServletRequest request) {
        if (request.getSession(false) != null) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMsg("이미 로그인이 되어있습니다.");
            responseDto.setResult(false);
            return responseDto;
        }
        System.out.println(registerDto);
        return userService.registerCheck(registerDto);
    }

    @PostMapping("/api/login")
    public LoginResponseDto login(@RequestBody LoginCheckDto loginCheckDto, HttpServletRequest request) {
        if (request.getSession(false) != null) {
            LoginResponseDto responseDto = new LoginResponseDto();
            responseDto.setResult(false);
            responseDto.setMsg("이미 로그인이 되어있습니다.");
            return responseDto;
        }
        LoginResponseDto loginResponseDto = userService.loginCheck(loginCheckDto);
        if(loginResponseDto.getResult()) {
            HttpSession session = request.getSession();
            session.setAttribute("loginResponseDto", loginResponseDto);
            System.out.println(session.getAttribute("loginResponseDto"));
        }

        return loginResponseDto;
    }
    @PostMapping("/api/logout")
    public ResponseDto logout (HttpSession session) {
        ResponseDto responseDto = new ResponseDto();
        session.invalidate();
        responseDto.setResult(true);
        responseDto.setMsg("로그아웃");
        return responseDto;
    }
}
