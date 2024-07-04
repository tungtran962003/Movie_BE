package com.example.movie_web_be.security.jwt;

import com.example.movie_web_be.security.service.UserDetailsImpl;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
public class JwtUtil {

    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;

    @Value("${bezkoder.app.jwtExpiration}")
    private Integer jwtExpiration;

    public String createToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .subject(userDetails.getEmail())     // set email vào mã token
                .issuedAt(new Date())                // set thời gian tạo mã
                .expiration(new Date(new Date().getTime() + jwtExpiration)) // set thời gian sống của mã
                .signWith(key())
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(token).getPayload();
//            Jwts.parser().setSigningKey(key()).build().parse(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(token).getPayload().getSubject();
    }
}
