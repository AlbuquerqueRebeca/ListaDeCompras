package com.projeto.projetolistacompras.Jwt;

import javax.naming.AuthenticationException;

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
   }





}
