package com.sparta.minicommunity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseDto {

    private boolean result;
    private String msg;

    public boolean getResult(){
        return result;
    }

}
