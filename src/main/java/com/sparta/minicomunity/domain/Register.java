package com.sparta.minicomunity.domain;

import com.sparta.minicomunity.Dto.RegisterDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Register extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userPwdCheck;

    @Column(nullable = false)
    private String nickName;

    public Register(RegisterDto registerDto){
        this.userId = registerDto.getUserId();
        this.password = registerDto.getPassword();
        this.userPwdCheck = registerDto.getUserPwdCheck();
        this.nickName = registerDto.getNickName();
    }
}
