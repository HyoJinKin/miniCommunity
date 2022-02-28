package com.sparta.minicommunity.service;

import com.sparta.minicommunity.dto.requestDto.LoginCheckDto;
import com.sparta.minicommunity.dto.requestDto.RegisterDto;
import com.sparta.minicommunity.dto.responseDto.LoginResponseDto;
import com.sparta.minicommunity.dto.responseDto.ResponseDto;
import com.sparta.minicommunity.models.User;
import com.sparta.minicommunity.repository.LikeRepository;
import com.sparta.minicommunity.repository.PostRepository;
import com.sparta.minicommunity.repository.UserRepository;

import com.sparta.minicommunity.security.JwtTokenProvider;
import lombok.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.regex.Pattern;

@Getter
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseDto registerCheck(RegisterDto registerDto) {

        ResponseDto responseDto = new ResponseDto();
        ResponseDto responseDto1 = registerValidation(registerDto, responseDto);
        if (responseDto1 != null) return responseDto1;

        responseDto.setResult(true);
        responseDto.setMsg("회원가입이 완료되었습니다.");
        String password = passwordEncoder.encode(registerDto.getPassword());
        registerDto.encodedPassword(password);
        userRepository.save(RegisterDto.toEntity(registerDto));

        return responseDto;
    }

    private ResponseDto registerValidation(RegisterDto registerDto, ResponseDto responseDto) {
        if (!(registerDto.getPassword().equals(registerDto.getPasswordCheck()))) {
            responseDto.setResult(false);
            responseDto.setMsg("비밀번호가 같지 않습니다.");
            return responseDto;
        }
        if (registerDto.getPassword().contains(registerDto.getNickName()) || registerDto.getPassword().length() < 4) {
            responseDto.setResult(false);
            responseDto.setMsg("비밀번호를 4자리 이상, 닉네임이 들어가지 않게 작성해주세요");
            return responseDto;
        }
        String pattern = "[0-9a-zA-Z]{3,}";
        boolean regex = Pattern.matches(pattern, registerDto.getNickName());
        if (!regex) {
            responseDto.setResult(false);
            responseDto.setMsg("닉네임을 3자리 이상, 숫자, 영문자로만 입력해주세요");
            return responseDto;
        }
        return null;
    }

    @Transactional
    public LoginResponseDto loginCheck(LoginCheckDto loginCheckDto){
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        User user = userRepository.findByUsername(loginCheckDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("가입되지 않은 유저입니다."));

        if (!passwordEncoder.matches(loginCheckDto.getPassword(), user.getPassword())) {
            loginResponseDto.setResult(false);
            loginResponseDto.setMsg("비밀번호를 확인해주세요");
        }
        String token = jwtTokenProvider.createToken(user.getUsername(), user.getId(), user.getUsername(), user.getNickName());
        loginResponseDto.setResult(true);
        loginResponseDto.setMsg("로그인 되었습니다.");
        loginResponseDto.setTokenname(token);


        return loginResponseDto;
    }


}