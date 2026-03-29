package com.gxhenrique.projetoLinks.security.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {

    private final String SECRET_KEY = "minha_chave_super_secreta_12345678901234567890";

    // 🔐 Gerar token
    public String generateToken(String username) {

        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
    }

    // 📥 Pegar username do token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // 📦 Pegar informações do token
    public Claims extractClaims(String token) {

        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // ✅ Validar token
    public boolean isTokenValid(String token, String username) {
        final String userToken = extractUsername(token);
        return (userToken.equals(username) && !isTokenExpired(token));
    }

    // ⏰ Verifica expiração
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}