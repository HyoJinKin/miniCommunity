package com.sparta.minicommunity.service;

import com.sparta.minicommunity.dto.requestDto.PostDto;
import com.sparta.minicommunity.dto.requestDto.PostRemoveDto;
import com.sparta.minicommunity.dto.requestDto.PostUpdateDto;
import com.sparta.minicommunity.dto.responseDto.ResponseDto;
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
    public ResponseDto postingPost(PostDto postDto) {
        Post post = new Post(postDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResult(true);
        responseDto.setMsg("등록 성공");
        postRepository.save(post);

        return responseDto;
    }

    @Transactional
    public ResponseDto postUpdate(PostUpdateDto postUpdateDto) {
        ResponseDto responseDto = new ResponseDto();

        Post post = postRepository.findById(postUpdateDto.getPostId()).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.update(postUpdateDto);
        responseDto.setResult(true);
        responseDto.setMsg("수정이 정상적으로 처리되었습니다.");
        return responseDto;
    }

    @Transactional
    public ResponseDto deletingPost(PostRemoveDto postRemoveDto) {
        ResponseDto responseDto = new ResponseDto();

        postRepository.deleteById(postRemoveDto.getPostId());
        responseDto.setResult(true);
        responseDto.setMsg("삭제 완료");

        return responseDto;
    }
    @Transactional
    public Long updateLike(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.plusLike();
        return id;
    }
    @Transactional
    public Long minusLike(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.minusLike();
        return id;
    }
}
