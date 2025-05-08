package com.projeto.projetolistacompras.Service;

import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	private final UsuarioRepository usuarioRepository; 
	
	private final BCryptPasswordEncoder passwordEncoder; 
	 
	
}

	


