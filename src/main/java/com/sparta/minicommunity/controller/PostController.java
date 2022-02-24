package com.sparta.minicommunity.controller;

import com.sparta.minicommunity.dto.PostDto;
import com.sparta.minicommunity.dto.PostRemoveDto;
import com.sparta.minicommunity.dto.PostUpdateDto;
import com.sparta.minicommunity.dto.ResponseDto;
import com.sparta.minicommunity.models.Post;
import com.sparta.minicommunity.repository.PostRepository;
import com.sparta.minicommunity.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "https://spartaweek2-25f73.firebaseapp.com/")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/api/post")
    public ResponseDto creatPost(@RequestBody PostDto postDto, HttpServletRequest request){
        Post post = new Post(postDto);
        ResponseDto responseDto = new ResponseDto();

        if (request.getSession(false) == null) { // 세션이 없을 시 로그인 요청
            System.out.println("\n" + request.getSession(false));
            responseDto.setResult(false);
            responseDto.setMsg("로그인을 해주세요");
            return responseDto;
        }
        responseDto.setResult(true);
        responseDto.setMsg("등록 성공");
        postRepository.save(post);
        return responseDto;
    }

    @GetMapping("/api/post")
    public List<Post> readPost() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping ("/api/post")
    public ResponseDto modifyPost(@RequestBody PostUpdateDto postUpdateDto) {
        return postService.postUpdate(postUpdateDto);
    }

    @DeleteMapping ("/api/post")
    public ResponseDto deletePost(@RequestBody PostRemoveDto postRemoveDto) {
        postRepository.deleteById(postRemoveDto.getPostId());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResult(true);
        responseDto.setMsg("삭제 완료");
        return responseDto;
    }
}
