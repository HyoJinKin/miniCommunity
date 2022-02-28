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
            }
        }
    }
}