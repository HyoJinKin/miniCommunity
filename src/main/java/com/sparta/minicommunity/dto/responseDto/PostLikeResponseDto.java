package com.sparta.minicommunity.dto.responseDto;

import com.sparta.minicommunity.models.LikeNumber;
import com.sparta.minicommunity.models.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostLikeResponseDto {
    private List<Post> total;
    private List<LikeNumber> myLike;
}
