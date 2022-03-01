package com.sparta.minicommunity.service;

import com.sparta.minicommunity.dto.requestDto.PostDto;
import com.sparta.minicommunity.dto.requestDto.PostUpdateDto;
import com.sparta.minicommunity.dto.responseDto.ResponseDto;
import com.sparta.minicommunity.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    PostRepository postRepository;

    @Test
    @DisplayName("포스팅 등록 테스트")
    void PostSave() {
        // given

        PostDto postDto = new PostDto(
                "이런이런",
                "nick",
                "https://mblogthumb-phinf.pstatic.net/20141207_41/qw1460_1417954367152S0Cjr_JPEG/KakaoTalk_20141206_192047443.jpg?type=w420",
                "full"
        );
        PostService PostService = new PostService(postRepository);

        // when
        // 포스트 등록
        ResponseDto responseDto = PostService.postingPost(postDto);
        assertEquals("등록 성공", responseDto.getMsg());
        assertEquals(true, responseDto.getResult());


    }
    @Test
    @DisplayName("포스트 업데이트 테스트")
    void updatePost() {
        PostDto postDto = new PostDto(
                "nick",
                "이런이런",
                "https://mblogthumb-phinf.pstatic.net/20141207_41/qw1460_1417954367152S0Cjr_JPEG/KakaoTalk_20141206_192047443.jpg?type=w420",
                "full"
        );
        // mock 객체생성
        PostService postService = new PostService(postRepository);


        // 포스트 등록
        ResponseDto responseDto = postService.postingPost(postDto);

        PostUpdateDto postUpdateDto = new PostUpdateDto(
            1L,
            "gywls",
            "이런이런",
            "https://mblogthumb-phinf.pstatic.net/20141207_41/qw1460_1417954367152S0Cjr_JPEG/KakaoTalk_20141206_192047443.jpg?type=w420",
            "full",
                0
        );
        ResponseDto responseDto1 = postService.postUpdate(postUpdateDto);

        assertEquals("수정이 정상적으로 처리되었습니다.", responseDto1.getMsg());
        assertEquals(true, responseDto1.getResult());
    }
}