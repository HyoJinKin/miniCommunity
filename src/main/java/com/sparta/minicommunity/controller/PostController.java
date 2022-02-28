package com.sparta.minicommunity.controller;

import com.sparta.minicommunity.dto.requestDto.PostDto;
import com.sparta.minicommunity.dto.requestDto.PostRemoveDto;
import com.sparta.minicommunity.dto.requestDto.PostUpdateDto;
import com.sparta.minicommunity.dto.requestDto.PostFindRequestDto;
import com.sparta.minicommunity.dto.responseDto.PostLikeResponseDto;
import com.sparta.minicommunity.dto.responseDto.ResponseDto;
import com.sparta.minicommunity.models.Post;
import com.sparta.minicommunity.repository.LikeRepository;
import com.sparta.minicommunity.repository.PostRepository;
import com.sparta.minicommunity.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://spartaweek2-25f73.firebaseapp.com/")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/api/post")
    public ResponseDto creatPost(@RequestBody PostDto postDto){
        return postService.postingPost(postDto);
    }

    @PostMapping("/api/showpost")
    public PostLikeResponseDto readPost(@RequestBody PostFindRequestDto postfindRequestDto) {
        PostLikeResponseDto postLikeResponseDto = new PostLikeResponseDto();
        postLikeResponseDto.setTotal(postRepository.findAllByOrderByModifiedAtDesc());
        postLikeResponseDto.setMyLike(likeRepository.findByUserId(postfindRequestDto.getUserId()));
        System.out.println(postLikeResponseDto.getTotal());
        System.out.println(postLikeResponseDto.getMyLike());
        return postLikeResponseDto;
    }

    @PutMapping ("/api/post")
    public ResponseDto modifyPost(@RequestBody PostUpdateDto postUpdateDto) {
        return postService.postUpdate(postUpdateDto);
    }

    @DeleteMapping ("/api/post")
    public ResponseDto deletePost(@RequestBody PostRemoveDto postRemoveDto) {
        return postService.deletingPost(postRemoveDto);
    }
}
