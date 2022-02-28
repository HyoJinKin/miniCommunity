package com.sparta.minicommunity.validator;

import com.sparta.minicommunity.dto.requestDto.PostDto;
import org.springframework.stereotype.Component;


@Component
public class PostValidator {
    public static void ValidatePostInput(PostDto postDto) {
        if (postDto.getContents() == null || postDto.getContents().isEmpty()) {
            throw new IllegalArgumentException("작성한 컨텐츠가 없습니다. 입력해주세요");
        }
        if (postDto.getNickName() == null || postDto.getNickName().isEmpty()) {
            throw new IllegalArgumentException("닉네임을 입력해주세요");
        }
        if (!UrlValidator.isValidUrl(postDto.getImage())) {
            throw new IllegalArgumentException("이미지 url 포멧 형식이 올바르지 않습니다.");
        }
        if (postDto.getType() == null || postDto.getType().isEmpty()) {
            throw new IllegalArgumentException("타입을 정해주세요");
        }
    }
}
