package com.sparta.minicommunity.controller;

import com.sparta.minicommunity.dto.LikeRequestDto;
import com.sparta.minicommunity.dto.ResponseDto;
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
    @PostMapping("api/Like")
    public ResponseDto postLike(@RequestBody LikeRequestDto likeRequestDto, HttpServletRequest request) {
        // 세션 존재 확인
        ResponseDto responseDto = new ResponseDto();
        if (request.getSession(false) == null) {
            responseDto.setResult(false);
            responseDto.setMsg("로그인을 해주세요");
            return responseDto;
        }
        return likeService.plusLike(likeRequestDto);
    }

    @DeleteMapping("api/Like")
    public ResponseDto deleteLike(@RequestBody LikeRequestDto likeRequestDto) {
        return likeService.delLike(likeRequestDto);
    }
}
