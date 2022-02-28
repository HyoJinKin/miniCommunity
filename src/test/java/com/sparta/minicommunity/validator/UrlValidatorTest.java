package com.sparta.minicommunity.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UrlValidatorTest {
    @Test
    @DisplayName("URL 형태: 정상")
    void urlValidator() {
        // given
        String url = "https://mblogthumb-phinf.pstatic.net/20141207_41/qw1460_1417954367152S0Cjr_JPEG/KakaoTalk_20141206_192047443.jpg?type=w420";

        // when
        boolean isValid = UrlValidator.isValidUrl(url);

        //then
        assertTrue(isValid);
    }

    @Test
    @DisplayName("URL 형태: 비정상 (null인 경우)")
    void urlValidator1() {
        // given
        String url = null;

        // when
        boolean isValid = UrlValidator.isValidUrl(url);

        // then
        assertFalse(isValid);
    }

    @Test
    @DisplayName("URL 형태: 비정상 (빈 문자열인 경우)")
    void urlValidator2() {
        // given
        String url = "";

        // when
        boolean isValid = UrlValidator.isValidUrl(url);

        // then
        assertFalse(isValid);
    }

    @Test
    @DisplayName("URL 형태: 비정상 ('://' 빠짐)")
    void urlValidator3() {
        // given
        String url = "httpfacebook.com";

        // when
        boolean isValid = UrlValidator.isValidUrl(url);

        // then
        assertFalse(isValid);
    }

}