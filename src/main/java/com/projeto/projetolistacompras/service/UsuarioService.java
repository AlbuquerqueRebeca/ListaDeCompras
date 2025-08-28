package com.projeto.projetolistacompras.service;





import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Entidade.Usuario;
import com.projeto.projetolistacompras.Repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	private final UsuarioRepository usuarioRepository; 
	
	private final PasswordEncoder passwordEncoder; 
	
	
	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) { 
		this.usuarioRepository = usuarioRepository;  
		this.passwordEncoder = passwordEncoder; 
		
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	
	public boolean validarSenha(String senhaDigitada, String senhaArmazenada) {
		return passwordEncoder.matches(senhaDigitada, senhaArmazenada);
		
	}
	
	public void excluirUsuario(String  email) { 
		usuarioRepository.deleteById(email); 
	}
	
	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	
	public void inserir(UsuariDto usuario) {
	Usuario usuario = new Usuario(usuario);
	Usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
	usuarioRepository.save(usuario);
	}
	
	
	 
	
}

	


