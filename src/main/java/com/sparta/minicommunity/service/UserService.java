package com.sparta.minicommunity.service;

import com.sparta.minicommunity.dto.*;
import com.sparta.minicommunity.models.User;
import com.sparta.minicommunity.repository.LikeRepository;
import com.sparta.minicommunity.repository.PostRepository;
import com.sparta.minicommunity.repository.UserRepository;
import lombok.*;
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

    @Transactional
    public ResponseDto registerCheck(RegisterDto registerDto) {
        ResponseDto responseDto = new ResponseDto();
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
        responseDto.setResult(true);
        responseDto.setMsg("회원가입이 완료되었습니다.");
//        String username = registerDto.getUsername();
//        String password = passwordEncoder.encode(registerDto.getPassword());
//        String userPwdCheck = passwordEncoder.encode(registerDto.getUserPwdCheck());
//        String nickName = registerDto.getNickName();

        User user = new User(registerDto);
        userRepository.save(user);

        return responseDto;
    }

    @Transactional
    public LoginResponseDto loginCheck(LoginCheckDto loginCheckDto){
        String id = loginCheckDto.getUsername();
        User user = userRepository.findByUsername(id);
        boolean check = userRepository.existsByUsernameAndPassword(loginCheckDto.getUsername(), loginCheckDto.getPassword());


        LoginResponseDto loginResponseDto = new LoginResponseDto();
        if (!check) {
            loginResponseDto.setMsg("아이디 비밀번호를 확인해주세요");
            loginResponseDto.setResult(false);
            return loginResponseDto;
        }
        loginResponseDto.setMsg("로그인 되었습니다.");
        loginResponseDto.setResult(true);
        loginResponseDto.setUsername(id);
        loginResponseDto.setNickName(user.getNickName());

        return loginResponseDto;
    }


}