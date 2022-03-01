package com.sparta.minicommunity.mockobject;

import com.sparta.minicommunity.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockPostRepository {

    private final List<Post> posts = new ArrayList<>();
    // 포스트 테이블 ID: 1부터 시작
    private Long postId = 1L;

    // 포스트 등록
    public void save(Post post) {
        // 새로운 포스트 -> DB 에 저장
        post.setId(postId);
        ++postId;
        posts.add(post);
        System.out.println(posts);
    }

    // 상품 ID 로 상품 조회
    public Optional<Post> findById(Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return Optional.of(post);
            }
            System.out.println(post.getId());
        }

        return Optional.empty();
    }

    public void deleteById(Long id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
}
///////////////////

