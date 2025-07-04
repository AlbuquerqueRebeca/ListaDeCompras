package com.projeto.projetolistacompras.service;

import java.util.Optional;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Entidade.Usuario;
import com.projeto.projetolistacompras.Repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	private final UsuarioRepository usuarioRepository; 
	
	private final BCryptPasswordEncoder passwordEncoder; 
	
	
	public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) { 
		this.usuarioRepository = usuarioRepository;  
		this.passwordEncoder = passwordEncoder; 
		
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	
	public Optional<Usuario> buscarPorId(Long id){
	    return usuarioRepository.findById(id);		 
	}
	
	public boolean validarSenha(String senhaDigitada, String senhaArmazenada) {
		return passwordEncoder.matches(senhaDigitada, senhaArmazenada);
		
	}
	
	public void excluirUsuario(Long id) { 
		usuarioRepository.deleteById(id); 
	}
	
	
	
	
	
	 
	
}

	


