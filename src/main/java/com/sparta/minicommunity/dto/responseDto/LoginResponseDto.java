package com.sparta.minicommunity.dto.responseDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginResponseDto {

    private boolean result;

    private String msg;

    private String tokenname;

    public boolean getResult() {
        return result;
    }
}
