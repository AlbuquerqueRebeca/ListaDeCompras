package com.projeto.projetolistacompras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Dto.AcessDto;
import com.projeto.projetolistacompras.Dto.AuthenticationDto;
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
		         Authentication authentication = authenticationManager.authenticate(userAuth);
		         
		         UsuarioDetailsImpl userAuthenticate = (UsuarioDetailsImpl) authentication.getPrincipal();
		         
		         String token = jwtUtil.generateTokenFromUserDetailsImpl(userAuthenticate);
		          
		          AcessDto acessDto = new AcessDto(token);
		          System.out.println("Authenticação bem sucedida!!" + authDto.getUsername());
		              
		                  return acessDto;
		             
		            }catch(BadCredentialsException e) {
		            	
		            }
		   
		                       return  new AcessDto("Acesso negado");
		
	}
	
	
}
