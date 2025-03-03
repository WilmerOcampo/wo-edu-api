package com.wo.edu.web.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtils {
    @Value("${security.jwt.key}")
    private String key;

    @Value("${security.jwt.user}")
    private String user;

    // CREAR TOKEN
    public String createToken(Authentication authentication) {
        Algorithm algorithm = Algorithm.HMAC256(this.key);

        String username = authentication.getPrincipal().toString();
        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return JWT.create()
                .withIssuer(this.user)
                .withSubject(username)
                .withClaim("authorities", authorities)
                .withIssuedAt(new Date())
                //.withExpiresAt(new Date(System.currentTimeMillis() + 900000))
                .withExpiresAt(new Date(System.currentTimeMillis() + 30000))
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm);
    }

    // VALIDAR TOKEN
    public DecodedJWT validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.key);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(this.user)
                    .build();

            return verifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Token invalid, not Authorized");
        }
    }

    // EXTRAER USUARIO DEL TOKEN
    public String getSubject(DecodedJWT decodedJWT) {
        return decodedJWT.getSubject();
    }

    // EXTRAER CLAIM ESPECIFICO
    public Claim getSpecificClaim(DecodedJWT decodedJWT, String claimName) {
        return decodedJWT.getClaim(claimName);
    }

    // EXTRAER LOS CLAIMS
    public Map<String, Claim> getClaims(DecodedJWT decodedJWT) {
        return decodedJWT.getClaims();
    }
}
