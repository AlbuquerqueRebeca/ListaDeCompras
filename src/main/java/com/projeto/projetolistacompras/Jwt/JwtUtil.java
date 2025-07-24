package com.projeto.projetolistacompras.Jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	@Value("${projeto.jwtsecret}")
    private String jwtSecret;
	
	
	@Value("{projeto.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	
	public String generateTokenFromUserDetailsImpl(DetailsImpl userDetail) {
		System.out.println("Gerando token para Usuário" + userDetail.getUsername());
	    return Jwts.builder().setSubject(userDetail.getUsername())
	    		                    .setIssuedAt(new Date())
	    		                    .signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
	
	}
	
	public Key getSigninKey() {
	SecretKey key = keys	
	}
	
}
