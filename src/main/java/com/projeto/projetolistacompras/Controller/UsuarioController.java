package com.projeto.projetolistacompras.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetolistacompras.Entidade.Usuario;
import com.projeto.projetolistacompras.Repository.UsuarioRepository;
import com.projeto.projetolistacompras.service.UsuarioService;

@RestController
public class UsuarioController{
	
	
	@Autowired
	UsuarioRepository usuarioRepository; 
	
	@Autowired
	UsuarioService usuarioService; 
	
	
	//Criando novo usuario
	//Endpoint de criação de novo usuário
	//Rota publica
	@PostMapping("/usuarios/criar-usuario")
	
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


