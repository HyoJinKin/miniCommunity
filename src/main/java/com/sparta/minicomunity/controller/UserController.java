package com.sparta.minicomunity.controller;

import com.sparta.minicomunity.Dto.RegisterDto;
import com.sparta.minicomunity.domain.Register;
import com.sparta.minicomunity.repository.UserRepository;
import com.sparta.minicomunity.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final RegisterService registerService;

    @PostMapping("/api/register")
    public boolean userRegister(@RequestBody RegisterDto registerDto){
        boolean check = registerService.pwdCheck(registerDto);
        if (check) {
            Register register = new Register(registerDto);
            userRepository.save(register);
            return true;
        }
        return false;
    }
}
