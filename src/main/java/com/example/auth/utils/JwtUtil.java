package com.example.auth.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static String SECRET_KEY = "your_secret_key"; // Replace this with a secure key

    public static String generateToken(long userId) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userId);
    }

    private static String createToken(Map<String, Object> claims, long userId) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(userId)) // Convert userId to String
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token is valid for 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
