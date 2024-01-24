package com.uduran.apiservlet.webapp.headers.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class ColorServiceImpl implements ColorService{
    @Override
    public Optional<String> getColor(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new Cookie[0];
        return Arrays.stream(cookies).filter(c -> "color".equals(c.getName())).map(Cookie::getValue).findAny();
    }
}
