package com.sparta.minicommunity.validator;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlValidator {
    public static boolean isValidUrl(String image) {
        try {
            new URL(image).toURI();
            return true;
        } catch (URISyntaxException | MalformedURLException exception) {
            return false;
        }
    }
}
