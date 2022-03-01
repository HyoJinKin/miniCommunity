package com.sparta.minicommunity.mockobject;

import com.sparta.minicommunity.dto.requestDto.PostDto;
import com.sparta.minicommunity.dto.responseDto.ResponseDto;
import com.sparta.minicommunity.models.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockPostServiceTest {
    // given

    @Test
    @DisplayName("포스팅 등록 테스트")
    void PostSave() {
        // given

        PostDto postDto = new PostDto(
                "nick",
                "이런이런",
                "https://mblogthumb-phinf.pstatic.net/20141207_41/qw1460_1417954367152S0Cjr_JPEG/KakaoTalk_20141206_192047443.jpg?type=w420",
                "full"
        );
        // mock 객체생성
        MockPostService mockPostService = new MockPostService();

        // when
        // 포스트 등록
        Post post = mockPostService.postingPost(postDto);

        assertEquals(post.getContents(), postDto.getContents());
        assertEquals(post.getImage(), postDto.getImage());
        assertEquals(post.getNickName(), postDto.getNickName());
        assertEquals(post.getType(), postDto.getType());
    }
    @Test
    @DisplayName("포스트 업데이트 테스트")
    void PostUpdate() {
        // given
    }
}
