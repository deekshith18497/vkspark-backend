package com.vkspark.vkspark_backend.security;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "vksparksecretkeyvksparksecretkeyvkspark12345";

    private SecretKey getKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );
    }

    // =========================
    // Generate JWT Token
    // =========================

    public String generateToken(String email) {

        return Jwts.builder()

                .subject(email)

                .issuedAt(new Date(System.currentTimeMillis()))

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60
                        )
                )

                .signWith(getKey())

                .compact();
    }

    // =========================
    // Extract Email
    // =========================

    public String extractEmail(String token) {

        return extractClaim(token, Claims::getSubject);
    }

    // =========================
    // Extract Expiration
    // =========================

    public Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);
    }

    // =========================
    // Extract Any Claim
    // =========================

    public <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver) {

        Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    // =========================
    // Extract All Claims
    // =========================

    private Claims extractAllClaims(String token) {

        return Jwts.parser()

                .verifyWith(getKey())

                .build()

                .parseSignedClaims(token)

                .getPayload();
    }

    // =========================
    // Check Token Expired
    // =========================

    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    // =========================
    // Validate Token
    // =========================

    public boolean validateToken(
            String token,
            UserDetails userDetails) {

        String email = extractEmail(token);

        return email.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }
}