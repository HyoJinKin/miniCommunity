package com.sparta.minicommunity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class LikeRequestDto {

    private Long postId;
    private Long userId;
}
