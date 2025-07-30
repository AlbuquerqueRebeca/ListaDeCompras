package com.projeto.projetolistacompras.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.projeto.projetolistacompras.service.UsuarioDetailsServiceImpl;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthFilterToken extends OncePerRequestFilter{
	
	
	   
	  @Autowired
	  private JwtUtil jwtUtil;
	  
	  
	  @Autowired
	  private UsuarioDetailsServiceImpl userDetailService;
	  
	  
	  @Override
	  
	        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	                                      throws ServletException, IOException {
		                  
		            try {
		            	String jwt = getToken(request);
		            	System.out.println("Token recebido" + jwt);
		            	if(jwt != null && jwtUtil.validateJwtToken(jwt)) {
		            		
		            		      String username = jwtUtil.getUsernameToken(jwt);
		            		      System.out.println("Username extraido do Token" + username);
		            		      
		            		      
		            		      UserDetails userDetails = userDetailService.loadUserByUsername(username);
		            	          System.out.println("Detalhes de usuário carregados" + userDetails);
		            	
		            	
		            	
		            	}
		            }
	  }

}
