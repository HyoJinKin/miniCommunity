package com.sparta.minicomunity.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterDto {
    private String userId;
    private String password;
    private String userPwdCheck;
    private String nickName;
}
