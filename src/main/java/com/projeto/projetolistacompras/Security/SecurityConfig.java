package com.projeto.projetolistacompras.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
		
		
		
		
		                              .cors(Customizer.withDefaults())
		                              .csrf(csrf -> csrf.disable())
		                              .authorizeHttpRequests(auth -> auth
		                              .requestMatchers("/criar-usuario").permitAll()
		                              .anyRequest().authenticated()
		                              )
		                              //desativando sessoes no servidor e habilitando autenticação stateless
		                              .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		
		                       return http.build();
		                              
		
	}
	
}
