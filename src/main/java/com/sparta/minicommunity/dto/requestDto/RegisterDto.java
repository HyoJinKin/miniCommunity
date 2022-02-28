package com.sparta.minicommunity.dto.requestDto;

import com.sparta.minicommunity.models.User;
import lombok.Builder;
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
    @Builder
    public RegisterDto(String username, String password, String passwordCheck, String nickName) {
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.nickName = nickName;
    }
    public void encodedPassword(String password) {
        this.password = password;
    }
    public static User toEntity(RegisterDto registerDto) {
        return User.builder()
                .username(registerDto.getUsername())
                .password(registerDto.getPassword())
                .nickName(registerDto.getNickName())
                .build();
    }
}
