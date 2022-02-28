package com.sparta.minicommunity.models;

import com.sparta.minicommunity.dto.requestDto.PostDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    @Nested
    @DisplayName("포스트 테스트")
    class CreatPost {

        private String contents;
        private String nickName;
        private String image;
        private String type;

        @BeforeEach
        void postTest() {
            contents = "이런이런";
            nickName = "김효진";
            image = "https://mblogthumb-phinf.pstatic.net/20141207_41/qw1460_1417954367152S0Cjr_JPEG/KakaoTalk_20141206_192047443.jpg?type=w420";
            type = "left";
        }
        @Test
        @DisplayName("정상 케이스")
        void createUser_Nomal() {
            PostDto postDto = new PostDto(
                    contents,
                    nickName,
                    image,
                    type
            );
            Post post = new Post(postDto);

            assertEquals(contents, post.getContents());
            assertEquals(nickName, post.getNickName());
            assertEquals(image, post.getImage());
            assertEquals(type, post.getType());
        }

        @Nested
        @DisplayName("실패 케이스")
        class FailCases {
            @Nested
            @DisplayName("회원이 작성한 컨텐츠")
            class Contents {
                @Test
                @DisplayName("null")
                void fail1() {
                    //given
                    contents = null;

                    PostDto postDto = new PostDto(
                            contents,
                            nickName,
                            image,
                            type
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Post(postDto);
                    });

                    //then
                    assertEquals("작성한 컨텐츠가 없습니다. 입력해주세요", exception.getMessage());
                }
                @Test
                @DisplayName("빈 문자열")
                void fail2() {
                    // given
                    contents = "";

                    PostDto postDto = new PostDto(
                            contents,
                            nickName,
                            image,
                            type
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Post(postDto);
                    });

                    // then
                    assertEquals("작성한 컨텐츠가 없습니다. 입력해주세요", exception.getMessage());
                }
            }
            @Nested
            @DisplayName("회원이 작성한 닉넴임")
            class Nickname {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    nickName = null;

                    PostDto postDto = new PostDto(
                            contents,
                            nickName,
                            image,
                            type
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Post(postDto);
                    });

                    // then
                    assertEquals("닉네임을 입력해주세요", exception.getMessage());
                }
                @Test
                @DisplayName("빈 문자열")
                void fail2() {
                    // given
                    nickName = "";

                    PostDto postDto = new PostDto(
                            contents,
                            nickName,
                            image,
                            type
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Post(postDto);
                    });
                    // then
                    assertEquals("닉네임을 입력해주세요", exception.getMessage());
                }
            }
            @Nested
            @DisplayName("회원이 올리려는 이미지 Url")
            class ImgUrl {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    image = null;

                    PostDto postDto = new PostDto(
                            contents,
                            nickName,
                            image,
                            type
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Post(postDto);
                    });
                    // then
                    assertEquals("이미지 url 포멧 형식이 올바르지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("이메일 형식이 안맞음")
                void fail2() {
                    // given
                    image = "http";

                    PostDto postDto = new PostDto(
                            contents,
                            nickName,
                            image,
                            type
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Post(postDto);
                    });
                    // then
                    assertEquals("이미지 url 포멧 형식이 올바르지 않습니다.", exception.getMessage());
                }
            }
            @Nested
            @DisplayName("회원이 고른 타입")
            class postType {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    type = null;

                    PostDto postDto = new PostDto(
                            contents,
                            nickName,
                            image,
                            type
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Post(postDto);
                    });
                    // then
                    assertEquals("타입을 정해주세요", exception.getMessage());
                }
                @Test
                @DisplayName("빈 문자열")
                void fail2() {
                    // given
                    type = "";

                    PostDto postDto = new PostDto(
                            contents,
                            nickName,
                            image,
                            type
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Post(postDto);
                    });
                    // then
                    assertEquals("타입을 정해주세요", exception.getMessage());
                }
            }
        }
    }
}