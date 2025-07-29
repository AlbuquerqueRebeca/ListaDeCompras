package com.projeto.projetolistacompras.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.projeto.projetolistacompras.service.UsuarioDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthFilterToken extends OncePerRequestFilter{
	
	
	   
	  @Autowired
	  private JwtUtil jwtUtil;
	  
	  
	  @Autowired
	  private UsuarioDetailsServiceImpl userDetailService;
	  
	  
	  @Override
	  
	        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	                                                           

}
