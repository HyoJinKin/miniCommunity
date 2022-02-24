package com.sparta.minicommunity.models;

import com.sparta.minicommunity.dto.RegisterDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("정상케이스")
    void createUser_Normal() {
        String username = "gywls1474@nate.com";
        String password = "gywls12";
        String passwordCheck = "gywls12";
        String nickName = "tjdwls";

        RegisterDto registerDto = new RegisterDto(
                username,
                password,
                passwordCheck,
                nickName
            );
        User user = new User(registerDto);

        assertEquals(username, user.getUsername());

        assertEquals(password, user.getPassword());

        assertEquals(nickName, user.getNickName());
    }
}