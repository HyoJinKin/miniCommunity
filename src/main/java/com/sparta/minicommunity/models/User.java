package com.sparta.minicommunity.models;

import com.sparta.minicommunity.dto.RegisterDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickName;

    public User(String username, String password, String nickName) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
    }

    public User(RegisterDto registerDto) {
        this.username = registerDto.getUsername();
        this.password = registerDto.getPassword();
        this.nickName = registerDto.getNickName();
    }

//    public User(String username, String password, String userPwdCheck, String nickName) {
//        this.username = username;
//        this.password = password;
//        this.userPwdCheck = userPwdCheck;
//        this.nickName = nickName;
//    }
}
