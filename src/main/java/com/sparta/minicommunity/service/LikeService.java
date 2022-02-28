package com.sparta.minicommunity.service;

import com.sparta.minicommunity.dto.requestDto.LikeRequestDto;
import com.sparta.minicommunity.dto.requestDto.PostUpdateDto;
import com.sparta.minicommunity.dto.responseDto.ResponseDto;
import com.sparta.minicommunity.models.LikeNumber;
import com.sparta.minicommunity.models.Post;
import com.sparta.minicommunity.repository.LikeRepository;
import com.sparta.minicommunity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostService postService;

    @Transactional
    public ResponseDto plusLike(LikeRequestDto likeRequestDto) {
        boolean check = likeRepository.existsByUserIdAndPostId(likeRequestDto.getUserId(), likeRequestDto.getPostId());
        ResponseDto responseDto = new ResponseDto();
        if (check == false) {
            postService.updateLike(likeRequestDto.getPostId());
            LikeNumber likeNumber = new LikeNumber(likeRequestDto);
            likeRepository.save(likeNumber);
            responseDto.setResult(true);
            responseDto.setMsg("좋아요 추가!");
            return responseDto;
        }
        else {
            postService.minusLike(likeRequestDto.getPostId());
            likeRepository.deleteByPostIdAndUserId(likeRequestDto.getPostId(),likeRequestDto.getUserId());
            responseDto.setResult(false);
            responseDto.setMsg("좋아요 취소!");
            return responseDto;
        }
    }
}
