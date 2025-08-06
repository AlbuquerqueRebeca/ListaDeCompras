package com.projeto.projetolistacompras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Jwt.JwtUtil;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Autowired
	private JwtUtil jwtUtil;
	
	
	public AcessDto login(AuthenticationDto authDto) {
		
		   
		   try {
			     
			     UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
		   }
		
	}
	
	
}
