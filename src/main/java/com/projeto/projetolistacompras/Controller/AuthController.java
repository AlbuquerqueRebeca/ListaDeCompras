package com.projeto.projetolistacompras.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetolistacompras.service.AuthService;
import com.projeto.projetolistacompras.service.UsuarioService;

@RestController
@RequestMapping
public class AuthController {
	
	
	
	@Autowired
	private AuthService authService;
	
	
	@Autowired
	private UsuarioService usuarioService;

}
