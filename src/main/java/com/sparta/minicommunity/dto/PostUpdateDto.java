package com.sparta.minicommunity.dto;

import com.sparta.minicommunity.models.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class PostUpdateDto {
    private Long postId;
    private String nickName;
    private String contents;
    private String image;
    private String type;
    private int likeCount;

    public PostUpdateDto (Post post) {
        this.postId = post.getId();
        this.nickName = post.getNickName();
        this.contents = post.getContents();
        this.image = post.getImage();
        this.type = post.getType();
        this.likeCount = post.getLikeCount();
    }
}
