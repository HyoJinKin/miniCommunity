//package com.sparta.minicommunity.mockobject;
//
//import com.sparta.minicommunity.dto.requestDto.PostUpdateDto;
//import com.sparta.minicommunity.dto.responseDto.ResponseDto;
//import com.sparta.minicommunity.models.Post;
//import com.sparta.minicommunity.repository.PostRepository;
//
//import javax.transaction.Transactional;
//
//public class MockPostService {
//
//    private final MockPostRepository mockpostRepository;
//
//    public MockPostService() {
//        this.mockpostRepository = MockpostRepository;
//    }
//
//    public ResponseDto postUpdate(PostUpdateDto postUpdateDto) {
//        Post post = mockpostRepository.findById(postUpdateDto.getPostId()).orElseThrow(
//                () -> new NullPointerException("아이디가 존재하지 않습니다.")
//        );
//        post.update(postUpdateDto);
//        ResponseDto responseDto = new ResponseDto();
//        responseDto.setResult(true);
//        responseDto.setMsg("수정이 정상적으로 처리되었습니다.");
//        return responseDto;
//    }
//}
