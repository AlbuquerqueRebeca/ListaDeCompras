package com.projeto.projetolistacompras.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetolistacompras.service.AuthService;

@RestController
@RequestMapping
public class AuthController {
	
	
	
	@Autowired
	private AuthService authService;

}
