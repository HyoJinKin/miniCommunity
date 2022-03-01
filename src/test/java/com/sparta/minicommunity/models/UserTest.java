package com.sparta.minicommunity.models;

import com.sparta.minicommunity.dto.requestDto.RegisterDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Nested
    @DisplayName("유저 테스트")
    class UserTest_Case {
        private String username;
        private String password;
        private String passwordCheck;
        private String nickName;

        @BeforeEach
        void createUser() {
            username = "gywls1474@nate.com";
            password = "gywls12";
            passwordCheck = "gywls12";
            nickName = "tjdwls";
        }

        @Test
        @DisplayName("정상 케이스")
        void createUser_Nomal() {
            RegisterDto registerDto = new RegisterDto(
                    username,
                    password,
                    passwordCheck,
                    nickName
            );
            User user = new User(registerDto);

            assertEquals(username, user.getUsername());
            assertEquals(password, user.getPassword());
            assertEquals(nickName, user.getNickName());
        }

        @Nested
        @DisplayName("실패 케이스")
        class FailCase {
            @Nested
            @DisplayName("회원이 작성한 유저네임")
            class UserName {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    username = null;

                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    // then
                    assertEquals("유저네임의 값을 입력해주세요", exception.getMessage());
                }

                @Test
                @DisplayName("빈 문자열")
                void fail2() {
                    // given
                    username = "";

                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    //when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    //then
                    assertEquals("유저네임의 값을 입력해주세요", exception.getMessage());
                }
            }
            @Nested
            @DisplayName("회원이 작성한 패스워드")
            class PassWord {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    password = null;

                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    //when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    //then
                    assertEquals("비밀번호를 입력해주세요", exception.getMessage());
                }
                @Test
                @DisplayName("빈 문자열")
                void fail2() {
                    // given
                    password = "";

                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });

                    // then
                    assertEquals("비밀번호를 입력해주세요", exception.getMessage());
                }
                @Test
                @DisplayName("비밀번호가 같지 않을 때")
                void fail3() {
                    //given
                    password = "gywls";
                    passwordCheck = "gywls12";

                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    // then
                    assertEquals("비밀번호가 같지 않습니다.", exception.getMessage());
                }
                @Test
                @DisplayName("비밀번호가 4자리 미만일 때")
                void fail4() {
                    // given
                    password = "hyo";
                    passwordCheck = "hyo";
                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    // then
                    assertEquals("비밀번호 4자리 이상, 닉네임이 들어가지 않게 해주세요", exception.getMessage());
                }
                @Test
                @DisplayName("4자리 이상이지만, 닉네임이 들어갔을 때")
                void fail5() {
                    // given
                    password = "hyojin";
                    passwordCheck = "hyojin";
                    nickName = "hyojin";
                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    // then
                    assertEquals("비밀번호 4자리 이상, 닉네임이 들어가지 않게 해주세요", exception.getMessage());
                }
            }
            @Nested
            @DisplayName("회원이 작성한 닉네임")
            class NickName {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    nickName = null;

                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    // then
                    assertEquals("닉네임을 입력해주세요", exception.getMessage());
                }
                @Test
                @DisplayName("빈 문자열")
                void fail2() {
                    // given
                    nickName = "";

                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    // then
                    assertEquals("닉네임을 입력해주세요", exception.getMessage());
                }
                @Test
                @DisplayName("닉네임이 3자 미만일 때")
                void fail3() {
                    // given
                    nickName = "hh";

                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    // then
                    assertEquals("닉네임을 3자리 이상, 숫자, 영문자로만 입력해주세요", exception.getMessage());
                }
                @Test
                @DisplayName("닉네임이 영문자가 아닐 때")
                void fail4() {
                    // given
                    nickName = "@@@@@";
                    RegisterDto registerDto = new RegisterDto(
                            username,
                            password,
                            passwordCheck,
                            nickName
                    );
                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(registerDto);
                    });
                    // then
                    assertEquals("닉네임을 3자리 이상, 숫자, 영문자로만 입력해주세요", exception.getMessage());
                }
            }
        }
    }
}