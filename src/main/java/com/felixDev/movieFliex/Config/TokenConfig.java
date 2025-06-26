package com.felixDev.movieFliex.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.felixDev.movieFliex.Entity.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    @Value("${movieflix.security.secret}")
    private String secret;

    public String generateToken(Users users){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(users.getEmail())
                .withClaim("userId", users.getId())
                .withClaim("userName", users.getId())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuer("Api Movieflix")
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(JWTUserData.builder()
                    .id(jwt.getClaim("userID").asLong())
                    .name(jwt.getClaim("userName").asString())
                    .email(jwt.getSubject())
                    .build()
            );
        } catch (JWTVerificationException exception) {
            return Optional.empty();

        }

    }
}
