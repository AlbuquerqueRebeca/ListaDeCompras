package com.projeto.projetolistacompras.service;





import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Dto.UsuarioDto;
import com.projeto.projetolistacompras.Entidade.Usuario;
import com.projeto.projetolistacompras.Repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService{
	
	private final UsuarioRepository usuarioRepository; 
	
	private final PasswordEncoder passwordEncoder; 
	
	
	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) { 
		this.usuarioRepository = usuarioRepository;  
		this.passwordEncoder = passwordEncoder; 
		
	}
	
	@SuppressWarnings("null")
	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	
	public List<UsuarioDto> listarTodos(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDto::new).toList();
	}
	
	
	public boolean validarSenha(String senhaDigitada, String senhaArmazenada) {
		return passwordEncoder.matches(senhaDigitada, senhaArmazenada);
		
	}
	
	@Transactional
	public void excluirUsuario(String email){ 
		Usuario usuario = usuarioRepository.findByEmail(email)
		            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com esse email:    "));
					usuarioRepository.delete(usuario);
	}
	
	@SuppressWarnings("null")
	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);

	}
	
	
	public void inserir(UsuarioDto dto) {
    System.out.println("DTO senha:" + dto.getSenha());
	Usuario usuario = new Usuario(dto);
	System.out.println("senha antes da criptografia" + usuario.getSenha());
	usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
	usuarioRepository.save(usuario);
	System.out.println("senha criptografada" + usuario.getSenha());
	
	}
	
	
	 
	
}

	


