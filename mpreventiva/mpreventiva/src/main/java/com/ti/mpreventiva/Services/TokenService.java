package com.ti.mpreventiva.Services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ti.mpreventiva.Entities.Tecnico;

@Service
public class TokenService {

	@Value("jwt.secret=${jwt.secret}")
	// @Value("${jwt.secret}")
	private String secret;

	public String gerarToken(Tecnico tecnico) {
		try {
			var algorithm = Algorithm.HMAC256(secret);
			return JWT.create().withIssuer("Project").withSubject(tecnico.getLogin()).withExpiresAt(dataExpiracao())
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar o token", exception);
		}
	}

	public String getSubject(String TokenJWT) {
		try {
			var algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("Project").build().verify(TokenJWT).getSubject();

		} catch (JWTVerificationException exception) {
			throw new RuntimeException("Token invalido ou expirado");
		}
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
