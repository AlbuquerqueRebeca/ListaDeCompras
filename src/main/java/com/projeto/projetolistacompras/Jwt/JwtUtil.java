package com.projeto.projetolistacompras.Jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
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
	SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	System.out.println("Chave de assinatura gerada");
	return key;
	}
	
	public String getUsernameToken(String token) {
		System.out.println("Extraindo username do token" + token);
		return Jwts.parserBuilder()
				            .setSigningKey(getSigninKey())
				            .build()
				            .parseClaimsJws(token)
				            .getBody()
				            .getSubject();
}
	
	public boolean validateJwtToken(String authToken) {
		try {
			System.out.println("validando Token" + authToken);
			Claims claims = Jwts
					         .parserBuilder()
					         .setSigningKey(getSigninKey())
					         .build()
					         .parseClaimsJws(authToken)
					         .getBody();
			                return true;
			        }catch(MalformedJwtException e){
			        	System.out.println("Token Inválido" + e.getMessage());
			        }catch(ExpiredJwtException e) {
			        	System.out.println("Token Expirado" + e.getMessage());
			        }
	}
	
	
	
	
}
