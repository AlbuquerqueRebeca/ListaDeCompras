package com.projeto.projetolistacompras.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.projeto.projetolistacompras.service.UsuarioDetailsServiceImpl;

public class AuthFilterToken extends OncePerRequestFilter{
	
	
	   
	  @Autowired
	  private JwtUtil jwtUtil;
	  
	  
	  @Autowired
	  private UsuarioDetailsServiceImpl userDetailService;
	  
	  
	  @Override

}
