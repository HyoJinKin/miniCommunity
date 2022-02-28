package com.sparta.minicommunity.models;

import com.sparta.minicommunity.dto.requestDto.RegisterDto;
import com.sparta.minicommunity.validator.UserValidator;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User extends TimeStamped implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickName;

    public User(RegisterDto registerDto) {
        // 입력값 Validation
        UserValidator.ValidateUserInput(registerDto);

        this.username = registerDto.getUsername();
        this.password = registerDto.getPassword();
        this.nickName = registerDto.getNickName();
    }

    @Builder
    public User(String username, String password, String nickName) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
    }
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}