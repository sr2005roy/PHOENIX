package com.ecommerce.backendtwo.service;

import com.ecommerce.backendtwo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.valid-days}")
    private Integer validDays;

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private long getValidDuration() {
        return validDays * (24 * 60 * 60);
    }

    public String encode(User user) {
        return Jwts.builder()
                .setSubject(user.getUserId().toString())
                .claim("email", user.getEmail())
                .claim("userName", user.getUserName())
                .signWith(getSignInKey())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(getValidDuration())))
                .compact();
    }

    public User decode(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        Integer userId = Integer.parseInt(claims.getSubject());
        String userName = claims.get("userName", String.class);
        String email = claims.get("email", String.class);
        return new User(userId, userName, null, email, token);
    }
}
