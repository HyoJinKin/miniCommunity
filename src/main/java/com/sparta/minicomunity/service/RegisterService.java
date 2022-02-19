package com.sparta.minicomunity.service;

import com.sparta.minicomunity.Dto.RegisterDto;
import com.sparta.minicomunity.Dto.ResponseDto;
import com.sparta.minicomunity.domain.Register;
import com.sparta.minicomunity.repository.UserRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.regex.Pattern;

@Getter
@RequiredArgsConstructor
@Service
public class RegisterService {

    private final UserRepository userRepository;

    @Transactional
    public ResponseDto registerCheck(RegisterDto registerDto) {
        ResponseDto responseDto = new ResponseDto();
        if (!(registerDto.getPassword().equals(registerDto.getUserPwdCheck()))) {
            responseDto.setCheck(false);
            responseDto.setMessage("비밀번호가 같지 않습니다.");
            return responseDto;
        }
        if (registerDto.getPassword().contains(registerDto.getNickName()) || registerDto.getPassword().length() < 4) {
            responseDto.setCheck(false);
            responseDto.setMessage("비밀번호를 4자리 이상, 닉네임이 들어가지 않게 작성해주세요");
            return responseDto;
        }
        String pattern = "[0-9a-zA-Z]{3,}";
        boolean regex = Pattern.matches(pattern, registerDto.getNickName());
        if (regex == false) {
            responseDto.setCheck(false);
            responseDto.setMessage("닉네임을 3자리 이상, 숫자, 영문자로만 입력해주세요");
            return responseDto;
        }
        responseDto.setCheck(true);
        responseDto.setMessage("회원가입이 완료되었습니다.");

        Register register = new Register(registerDto);
        userRepository.save(register);

        return responseDto;
    }
}