package com.projeto.projetolistacompras.service;





import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Dto.UsuarioDto;
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
	
	public List<Usuario> listarTodos(){
		return usuarioRepository.findAll();
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
	
	
	public void inserir(UsuarioDto dto) {
	Usuario usuario = new Usuario(dto);
	usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
	usuarioRepository.save(usuario);
	}
	
	
	 
	
}

	


