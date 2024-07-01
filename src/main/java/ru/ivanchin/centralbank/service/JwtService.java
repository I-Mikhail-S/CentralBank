package ru.ivanchin.centralbank.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {

    public static final String SECRET_KEY = "7152a3d055cbe02fb1f85fcbbeecf1160effdb1b017809458046c7dcff6aac6a";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // извлекает тело из токена
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Objects> extractClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername()) // кодирование электронной почты пользоваателя
                .setIssuedAt(new Date(System.currentTimeMillis())) // дата создания заявки
                .setExpiration(new Date(System.currentTimeMillis() + 1000)) // дата истечения срока действия
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // каким ключом хотим подписать токен
                .compact(); // генерирует и возвращает токен
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // извлекает текст из зашифрованого токена
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey()) // установление ключа подписи
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    // получение ключа для входа в систему (цифровая подпись)
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes); // SHA4
    }

}
