package com.projeto.projetolistacompras.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetolistacompras.Dto.UsuarioDto;
import com.projeto.projetolistacompras.Entidade.Usuario;
import com.projeto.projetolistacompras.Repository.UsuarioRepository;
import com.projeto.projetolistacompras.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController{
	
	
	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	@Autowired
	private UsuarioService usuarioService; 
	
	
	//Criando novo usuario
	//Endpoint de criação de novo usuário
	//Rota publica
	@PostMapping("/criar-usuario")
	public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuario){
     usuarioService.salvar(usuario);
     return  ResponseEntity.ok("Conta criada com Sucesso!!!");

	}
	
	//endpoint temporario pra teste
	@GetMapping("/listar-todos")
	public List<Usuario>  listarTodos(){
	return usuarioService.listarTodos();
	}
	
	
	
	//Excluir Usuário
	//Endpoint para excluir usuario atráves do email
	@DeleteMapping("/deletar-perfil")
	public ResponseEntity<String>  excluirUsuario(String email){
	Optional<Usuario> apagarPerfil = usuarioRepository.findByEmail(email);
	if(apagarPerfil.isPresent()) {
		usuarioRepository.delete(apagarPerfil.get());
		return ResponseEntity.ok("Perfil deletado com Sucesso!!!");
		}else {
			return ResponseEntity.notFound().build();
		}
	
	  
	
			
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


