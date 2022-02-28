package com.sparta.minicommunity.dto.requestDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class LoginCheckDto {
    private String username;
    private String password;
}
