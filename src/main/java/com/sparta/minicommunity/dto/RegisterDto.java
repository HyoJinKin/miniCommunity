package com.sparta.minicommunity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class RegisterDto {
    private String username;
    private String password;
    private String passwordCheck;
    private String nickName;

    // 테스트 코드
    public RegisterDto(String username, String password, String passwordCheck, String nickName) {
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.nickName = nickName;
    }
}
