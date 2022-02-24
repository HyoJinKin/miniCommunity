package com.sparta.minicommunity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class PostDto {

    private String contents;

    private String nickName;

    private String image;

    private String type;

    private int likeCount;
}
