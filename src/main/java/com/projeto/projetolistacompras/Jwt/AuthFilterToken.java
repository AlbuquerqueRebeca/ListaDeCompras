package com.projeto.projetolistacompras.Jwt;

import java.io.IOException;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.lang.NonNull;

import com.projeto.projetolistacompras.service.UsuarioDetailsServiceImpl;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthFilterToken extends OncePerRequestFilter{
	
	
	private final JwtUtil jwtUtil;
	private final UsuarioDetailsServiceImpl userDetailService;
	
	   
	 public AuthFilterToken(JwtUtil jwtUtil, UsuarioDetailsServiceImpl userDetailService) {
		 this.jwtUtil = jwtUtil;
		 this.userDetailService = userDetailService;
	 }
	  
	  @Override
	  
	        protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
	                                      throws ServletException, IOException {
		  
		    
		 


		                  
		            try {
		            	String jwt = getToken(request);
		            	System.out.println("Token recebido" + jwt);
		            	if(jwt != null && jwtUtil.validateJwtToken(jwt)) {
		            		System.out.println("TOKEN VALIDO COM SUCESSO"); // log 
		            		      String username = jwtUtil.getUsernameToken(jwt);
		            		      System.out.println("Username EXTRAIDO do Token" + username);  //log 
		            		      
		            		      
		            		      UserDetails userDetails = userDetailService.loadUserByUsername(username);
		            	          System.out.println("Detalhes de usuário carregados" + userDetails); //log
		            	         UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		            	            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		            	             
		            	                 SecurityContextHolder.getContext().setAuthentication(auth);
		            	
		            	            }else {
		            	            	System.out.println("TOKEN INVALIDO OU AUSENTE");  // log 
		            	            }
		            	
		                         }catch(Exception e) {
		                        	 System.out.println("Ocorreu um erro ao processar o token"); // log
		                        	 
		                         }finally {
		                         
		                         
		                         } 
		            	            
		            	           filterChain.doFilter(request, response);
		            	
		            	
	                   }
	  
	                            private String getToken(HttpServletRequest request) {
	                            String headerToken = request.getHeader("Authorization");
	                            if(StringUtils.hasText(headerToken) && headerToken.startsWith("Bearer ")) {
	                            	return headerToken.replace("Bearer ", "");

	                            }
		            	
		            	              return null;
		            	
		            	
		            }
	  

}
