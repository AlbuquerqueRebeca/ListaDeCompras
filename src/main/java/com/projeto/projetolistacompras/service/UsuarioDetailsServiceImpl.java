package com.projeto.projetolistacompras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Entidade.Usuario;
import com.projeto.projetolistacompras.Repository.UsuarioRepository;


@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService{
	
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		 Usuario usuario = usuarioRepository.findByLogin(username).get();
	      

	      return UsuarioDetailsImpl.build(usuario);
	}


	//buscar usuario por email
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
	 Usuario usuario = usuarioRepository.findByEmail(email)
	 .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com email: " + email));
	  return UsuarioDetailsImpl.build(usuario);
	}

}
