package com.projeto.projetolistacompras.Jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
	
	@Value("${projeto.jwtsecret}")
    private String jwtSecret;
	
	
	@Value("{projeto.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	
	public String generateTokenFromUserDetailsImpl(DetailsImpl userDetail) {
		System.out.println("Gerando token para Usuário" + userDetail.getUsername());
	    return Jwts.builder().setSubject(userDetail.getUsername())
	    		                    .setIssuedAt(new date())
	    		                    .signWith(getSigninKey(),)
	
	}
	
}
