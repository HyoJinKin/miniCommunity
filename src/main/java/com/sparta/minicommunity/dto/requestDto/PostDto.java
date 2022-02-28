package com.sparta.minicommunity.dto.requestDto;

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

    // 테스트 코드
    public PostDto(String contents, String nickName, String image, String type) {
        this.contents = contents;
        this.nickName = nickName;
        this.image = image;
        this.type = type;
    }
}
