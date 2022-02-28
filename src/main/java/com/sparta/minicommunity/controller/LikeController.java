package com.sparta.minicommunity.controller;

import com.sparta.minicommunity.dto.requestDto.LikeRequestDto;
import com.sparta.minicommunity.dto.responseDto.ResponseDto;
import com.sparta.minicommunity.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "https://spartaweek2-25f73.firebaseapp.com/")
@RequiredArgsConstructor
@RestController
public class LikeController {

    private final LikeService likeService;

    // 게시글 좋아요
    @PostMapping("api/like")
    public ResponseDto postLike(@RequestBody LikeRequestDto likeRequestDto) {
        System.out.println("likePlus 실행");
        return likeService.plusLike(likeRequestDto);
    }
}
