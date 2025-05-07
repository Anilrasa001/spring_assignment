package com.demo.JWT_TokenGenerator;

import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
    // Make sure the string is at least 32 characters for HS256:
    private static final String SECRET_KEY = "secret123secret123secret123secret123";
    
    // Create a proper Key object for signing:
    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // Generates JWT token with username & role
    public static String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                // Token expires in 5 minutes
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5)) 
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Validates token and checks if the token’s role matches requiredRole
    public static boolean validateToken(String token, String requiredRole) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String role = claims.get("role", String.class);
            // If the role in the token matches the required role, return true
            return role.equals(requiredRole);
        } catch (Exception e) {
            System.out.println("Token invalid or expired: " + e.getMessage());
            return false;
        }
    }

    // Utility method to print out claims
    public static void printClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        System.out.println("User: " + claims.getSubject());
        System.out.println("Role: " + claims.get("role"));
    }
}
