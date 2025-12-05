package com.projeto.projetolistacompras.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetolistacompras.Dto.AuthenticationDto;
import com.projeto.projetolistacompras.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	
	
	@Autowired
	private AuthService authService;	
	
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<?>  login(@RequestBody AuthenticationDto authDto){
	  return ResponseEntity.ok(authService.login(authDto));
		
	}
	

}
