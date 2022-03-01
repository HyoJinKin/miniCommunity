package com.sparta.minicommunity.mockobject;

import com.sparta.minicommunity.dto.requestDto.PostDto;
import com.sparta.minicommunity.dto.requestDto.PostRemoveDto;
import com.sparta.minicommunity.dto.requestDto.PostUpdateDto;
import com.sparta.minicommunity.dto.responseDto.ResponseDto;
import com.sparta.minicommunity.models.Post;

public class MockPostService {

    private final MockPostRepository mockPostRepository;

    public MockPostService() {
        this.mockPostRepository = new MockPostRepository();
    }

    public Post postingPost(PostDto postDto) {
        Post post = new Post(postDto);
        mockPostRepository.save(post);
        return post;
    }


    public Post postUpdate(PostUpdateDto postUpdateDto) {

        Post post = mockPostRepository.findById(postUpdateDto.getPostId()).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.update(postUpdateDto);
        return post;
    }


    public ResponseDto deletingPost(PostRemoveDto postRemoveDto) {
        ResponseDto responseDto = new ResponseDto();

        mockPostRepository.deleteById(postRemoveDto.getPostId());
        responseDto.setResult(true);
        responseDto.setMsg("삭제 완료");

        return responseDto;
    }

    public Long updateLike(Long id) {
        Post post = mockPostRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.plusLike();
        return id;
    }

    public Long minusLike(Long id) {
        Post post = mockPostRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.minusLike();
        return id;
    }
}
/////////////////////////////
