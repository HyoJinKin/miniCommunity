package com.sparta.minicommunity.models;

import com.sparta.minicommunity.dto.requestDto.LikeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class LikeNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private Long userId;

    public LikeNumber (LikeRequestDto likeRequestDto) {
        this.postId = likeRequestDto.getPostId();
        this.userId = likeRequestDto.getUserId();
    }
}
