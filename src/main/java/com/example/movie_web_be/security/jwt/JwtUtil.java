package com.example.movie_web_be.security.jwt;

import com.example.movie_web_be.security.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
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
                .setSubject((userDetails.getEmail())) // Set email
                .setIssuedAt(new Date()) // Set tại thời điểm nào
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration)) // Set thời gian sống
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage()); // Token không đúng định dạng
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage()); // Token bị hết thời gian
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage()); // Không hỗ trợ token
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage()); // Có ký tự trống
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        }
        return false;
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody().getSubject();
    }
}
