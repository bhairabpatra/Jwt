package com.jwt.auth.Jwt.security;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException {
    public BlogAPIException(String message) {
        super(message);
    }
}
