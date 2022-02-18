package com.sparta.minicomunity.service;

import com.sparta.minicomunity.Dto.RegisterDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@RequiredArgsConstructor
@Service
public class RegisterService {

    public boolean pwdCheck(RegisterDto registerDto) {
        if (registerDto.getPassword().equals(registerDto.getUserPwdCheck())){
            return true;
        } else {
            return false;
        }
    }
}