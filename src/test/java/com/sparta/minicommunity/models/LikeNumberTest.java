package com.sparta.minicommunity.models;

import com.sparta.minicommunity.dto.requestDto.LikeRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LikeNumberTest {
    @Test
    @DisplayName("정상 케이스")
    void likeTest() {
        Long postId = 1L;
        Long userId = 2L;

        LikeRequestDto likeRequestDto = new LikeRequestDto(
                postId,
                userId
        );
        LikeNumber likeNumber = new LikeNumber(likeRequestDto);

        assertEquals(postId, likeNumber.getPostId());
        assertEquals(userId, likeNumber.getUserId());
    }

}