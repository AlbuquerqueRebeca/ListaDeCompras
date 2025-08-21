package com.projeto.projetolistacompras.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.projeto.projetolistacompras.Jwt.AuthEntrypointJwt;
import com.projeto.projetolistacompras.Jwt.AuthFilterToken;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	private AuthEntrypointJwt unauthorizedHandler;
	
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public AuthFilterToken authFilterToken() {
		return new AuthFilterToken();
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
		
		
		
		
		                              .cors(Customizer.withDefaults())
		                              .csrf(csrf -> csrf.disable())
		                              .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
		                              .authorizeHttpRequests(auth -> auth
		                              .requestMatchers("/usuarios/**","/login").permitAll()
		                              .anyRequest().authenticated()
		                              );
		                              
		
		
		                       return http.build();
		                              
		
	}
	
}
