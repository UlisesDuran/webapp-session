package com.uduran.apiservlet.webapp.headers.services;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface ColorService {
    Optional<String> getColor(HttpServletRequest req);
}
