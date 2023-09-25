package com.jwt.auth.Jwt.security;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app-jwt-expiration-milliseconds}")
    private Long JwtExpDate;


    // Generate JWT token
    public String generateToken(Authentication authentication) {
        String email = authentication.getDeclaringClass().getName();

        Date currentDate = new Date();
        Date expDate = new Date(currentDate.getTime() + JwtExpDate);

        String jwtToken = Jwts.builder()
                .setSubject(email)
                .setIssuedAt((new Date()))
                .setExpiration(expDate)
                .signWith(key())
                .compact();
        return jwtToken;
    }

    private Key key() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }

    // Validate Jwt token

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);
            return true;
        } catch (MalformedJwtException ex) {
            throw new BlogAPIException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new BlogAPIException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new BlogAPIException("Unsupported  JWT token");
        }
    }
}
