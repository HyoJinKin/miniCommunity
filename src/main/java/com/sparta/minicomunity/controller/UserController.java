package com.sparta.minicomunity.controller;

import com.sparta.minicomunity.Dto.RegisterDto;
import com.sparta.minicomunity.Dto.ResponseDto;
import com.sparta.minicomunity.repository.UserRepository;
import com.sparta.minicomunity.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final RegisterService registerService;

    @PostMapping("/api/register")
    public ResponseDto userRegister(@RequestBody RegisterDto registerDto) {
        return registerService.registerCheck(registerDto);
    }
}
