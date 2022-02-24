package com.sparta.minicommunity.service;

import com.sparta.minicommunity.dto.LikeRequestDto;
import com.sparta.minicommunity.dto.PostUpdateDto;
import com.sparta.minicommunity.dto.ResponseDto;
import com.sparta.minicommunity.models.LikeNumber;
import com.sparta.minicommunity.models.Post;
import com.sparta.minicommunity.repository.LikeRepository;
import com.sparta.minicommunity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    @Transactional
    public ResponseDto plusLike (LikeRequestDto likeRequestDto) {
        ResponseDto responseDto = new ResponseDto();

        //이미 좋아요를 눌렀을 때
        int likecnt = likeRepository.findByPostIdAndUserId(likeRequestDto.getPostId(), likeRequestDto.getUserId()).size();
        if (likecnt != 0) {
            responseDto.setResult(false);
            responseDto.setMsg("이미 존재합니다.");
            return responseDto;
        }
        // 좋아요 DB 저장
        LikeNumber likeNumber = new LikeNumber(likeRequestDto);
        likeRepository.save(likeNumber);

        Post post = postRepository.findById(likeRequestDto.getPostId())
                .orElseThrow(() -> new NullPointerException("아이디가 존재하지 않습니다."));

        PostUpdateDto postUpdateDto = new PostUpdateDto(post);
        postUpdateDto.setLikeCount(postUpdateDto.getLikeCount() + 1);

        post.update(postUpdateDto);

        responseDto.setResult(true);
        responseDto.setMsg("좋아요 성공");
        return responseDto;

    }
    @Transactional
    public ResponseDto delLike(LikeRequestDto likeRequestDto) {
        ResponseDto responseDto = new ResponseDto();

        // 값이 존재하지 않을 때 (생길 일 없음)
        int likecnt = likeRepository.findByPostIdAndUserId(likeRequestDto.getPostId(), likeRequestDto.getUserId()).size();
        if (likecnt == 0) {
            responseDto.setResult(false);
            responseDto.setMsg("값이 존재하지 않습니다.");
        }

        // like 디비에서 삭제
        List<LikeNumber> likeinfo = likeRepository.findByPostIdAndUserId(likeRequestDto.getPostId(), likeRequestDto.getUserId());
        likeRepository.deleteById(likeinfo.get(0).getId());

        // 해당 Post 게시물 likecount -1 해주기
        Post post = postRepository.findById(likeRequestDto.getPostId())
                .orElseThrow(() -> new NullPointerException("아이디가 존재하지 않습니다."));

        PostUpdateDto postUpdateDto = new PostUpdateDto(post);
        postUpdateDto.setLikeCount(postUpdateDto.getLikeCount() - 1);

        post.update(postUpdateDto);

        responseDto.setResult(true);
        responseDto.setMsg("삭제 성공");
        return responseDto;
    }
}
