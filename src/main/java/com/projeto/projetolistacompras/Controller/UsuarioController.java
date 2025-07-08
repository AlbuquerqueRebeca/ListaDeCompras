package com.projeto.projetolistacompras.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetolistacompras.Repository.UsuarioRepository;
import com.projeto.projetolistacompras.service.UsuarioService;

@RestController 
@RequestMapping("/usuarios") 
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	
	
	
	
	

}
