package com.projeto.projetolistacompras.service;

import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	private final UsuarioRepository usuarioRepository; 
	
	private final BCryptPasswordEncoder passwordEncoder; 
	
	
	public UsuarioService(UsuarioRepository usuarioRepository) { 
		this.usuarioRepository = usuarioRepository;  
		this.passwordEncoder = passwordEncoder; 
		
	}
	 
	
}

	


