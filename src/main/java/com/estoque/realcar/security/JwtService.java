package com.estoque.realcar.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
<<<<<<< HEAD
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
=======
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
>>>>>>> 0dc24ae (hash de senha)
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "YWJkaWVsZXN0b3F1ZXNlY3JldGtleTEyMzQ1Njc4OTA=";

<<<<<<< HEAD
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

=======
    // =============================
    // GERAR TOKEN
    // =============================
>>>>>>> 0dc24ae (hash de senha)
    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)
                )
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

<<<<<<< HEAD
=======
    // =============================
    // EXTRAIR USERNAME
    // =============================
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // =============================
    // VALIDAR TOKEN (⭐ FALTAVA)
    // =============================
    public boolean isTokenValid(String token, UserDetails userDetails) {

        final String username = extractUsername(token);

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    // =============================
    // VERIFICA EXPIRAÇÃO
    // =============================
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    // =============================
    // EXTRAIR CLAIMS
    // =============================
>>>>>>> 0dc24ae (hash de senha)
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

<<<<<<< HEAD
=======
    // =============================
    // CHAVE SECRETA
    // =============================
>>>>>>> 0dc24ae (hash de senha)
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
<<<<<<< HEAD
=======

>>>>>>> 0dc24ae (hash de senha)
}
