package com.sparta.minicommunity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginResponseDto {

    private boolean result;

    private String msg;

    private String username;

    private String nickName;

    public boolean getResult() {
        return result;
    }
}
