package ru.lozovoi.service.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class JwtTokenUtils {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.lifetime}")
    private Duration jwtLifeTime;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        List<String> rolesList = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        claims.put("roles", rolesList);
        Date issueDate = new Date();
        Date expiredDate = new Date(issueDate.getTime() + jwtLifeTime.toMillis());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(issueDate)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUsername(String token){
        return getAllClaimsFromToken(token).getSubject();
    }

    public List<String> getRoles(String token){
        return getAllClaimsFromToken(token).get("roles", List.class);
    }

    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
