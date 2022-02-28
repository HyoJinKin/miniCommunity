package com.sparta.minicommunity.repository;

import com.sparta.minicommunity.models.LikeNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<LikeNumber, Long> {
    boolean existsByUserIdAndPostId(Long userId, Long postId);
    List<LikeNumber> findByUserId(Long userId);
    void deleteByPostIdAndUserId(Long postId, Long userId);
}
