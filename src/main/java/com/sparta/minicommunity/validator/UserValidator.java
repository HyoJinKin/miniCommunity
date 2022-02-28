package com.sparta.minicommunity.validator;

import com.sparta.minicommunity.dto.requestDto.RegisterDto;

public class UserValidator {
    public static void ValidateUserInput(RegisterDto registerDto) {
        if (registerDto.getUsername() == null || registerDto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("유저네임의 값을 입력해주세요");
        }
        if (registerDto.getPassword() == null || registerDto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해주세요");
        }
        if (registerDto.getNickName() == null || registerDto.getNickName().isEmpty()) {
            throw new IllegalArgumentException("닉네임을 입력해주세요");
        }
    }
}
