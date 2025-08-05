package com.projeto.projetolistacompras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.projeto.projetolistacompras.Repository.UsuarioRepository;

public class UsuarioDetailsServiceImpl implements UserDetailsService{
	
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@Autowired
	public UserDetails loadUserByUsername(String username)

}
