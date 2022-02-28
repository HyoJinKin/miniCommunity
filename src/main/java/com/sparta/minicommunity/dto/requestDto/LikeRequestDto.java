package com.sparta.minicommunity.dto.requestDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class LikeRequestDto {

    private Long postId;
    private Long userId;

    // 테스트 코드
    public LikeRequestDto(Long postId, Long userId) {
        this.postId = postId;
        this.userId = userId;
    }
}
