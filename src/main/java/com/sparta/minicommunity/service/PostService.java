package com.sparta.minicommunity.service;

import com.sparta.minicommunity.dto.PostUpdateDto;
import com.sparta.minicommunity.dto.ResponseDto;
import com.sparta.minicommunity.models.Post;
import com.sparta.minicommunity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public ResponseDto postUpdate(PostUpdateDto postUpdateDto) {
        Post post = postRepository.findById(postUpdateDto.getPostId()).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.update(postUpdateDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResult(true);
        responseDto.setMsg("수정이 정상적으로 처리되었습니다.");
        return responseDto;
    }
}
