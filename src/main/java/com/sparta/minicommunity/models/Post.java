package com.sparta.minicommunity.models;

import com.sparta.minicommunity.dto.PostDto;
import com.sparta.minicommunity.dto.PostUpdateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity // 테이블 생성
@NoArgsConstructor // 기본 생성자
public class Post extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // id 값 1씩 알아서 증가
    private Long id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String type;

    @Column
    private int likeCount;

    public Post (PostDto postDto) {
        this.contents = postDto.getContents();
        this.nickName = postDto.getNickName();
        this.image = postDto.getImage();
        this.type = postDto.getType();
        this.likeCount = 0;
    }

    public void update (PostUpdateDto postUpdateDto) {
        this.contents = postUpdateDto.getContents();
        this.nickName = postUpdateDto.getNickName();
        this.likeCount = postUpdateDto.getLikeCount();
        this.image = postUpdateDto.getImage();
        this.type = postUpdateDto.getType();
    }
}
