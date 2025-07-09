package com.projeto.projetolistacompras.Controller;

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
@RequestMapping("/usuarios") 
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	
	
	//criando novo usuario
	@PostMapping("/criar-usuario")
	public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuario){
		usuarioService.salvar(usuario);  //criar o metodo salvar na classe usuarioservice
		return ResponseEntity.ok("Conta criada com Sucesso!!");
				}
	
	
// excluir usuario
	
@DeleteMapping("deletar-perfil")
public ResponseEntity<String> ExcluirUsuario(@RequestParam String email){
	
}
	
	
	

}
