package com.projeto.projetolistacompras.Jwt;

import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;

import org.springframework.http.MediaType;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthEntrypointJwt implements AuthenticationEntryPoint {


   @Override
   public void commence(HttpServletRequest request, HttpServletResponse response,
		   AuthenticationException authException) throws IOException, ServletException{
	     System.out.println("Solicitação não autorizada: " + request.getRequestURI());
	     System.out.println("Exceção de autenticação: " + authException.getMessage());
	     
	     
	              response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	              response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	     
	               final Map<String, Object> body = new HashMap<>();
	     
	     
	     
	     
   }





}
