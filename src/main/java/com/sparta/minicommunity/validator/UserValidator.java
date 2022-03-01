package com.sparta.minicommunity.validator;

import com.sparta.minicommunity.dto.requestDto.RegisterDto;

import java.util.regex.Pattern;

public class UserValidator {
    public static void ValidateUserInput(RegisterDto registerDto) {
        if (registerDto.getUsername() == null || registerDto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("유저네임의 값을 입력해주세요");
        }
        if (!(registerDto.getPassword().equals(registerDto.getPasswordCheck()))) {
            throw new IllegalArgumentException("비밀번호가 같지 않습니다.");
        }
        if (registerDto.getPassword().contains(registerDto.getNickName()) || registerDto.getPassword().length() < 4) {
            throw new IllegalArgumentException("비밀번호 4자리 이상, 닉네임이 들어가지 않게 해주세요");
        }
        if (registerDto.getPassword() == null || registerDto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해주세요");
        }
        if (registerDto.getNickName() == null || registerDto.getNickName().isEmpty()) {
            throw new IllegalArgumentException("닉네임을 입력해주세요");
        }
        String pattern = "[0-9a-zA-Z]{3,}";
        boolean regex = Pattern.matches(pattern, registerDto.getNickName());
        if (!regex) {
            throw new IllegalArgumentException("닉네임을 3자리 이상, 숫자, 영문자로만 입력해주세요");
        }
    }
}
