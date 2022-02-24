package com.sparta.minicommunity.repository;

import com.sparta.minicommunity.models.LikeNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<LikeNumber, Long> {
    List<LikeNumber> findByPostIdAndUserId(Long postId, Long userId);
}
