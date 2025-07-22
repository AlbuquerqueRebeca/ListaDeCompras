package com.projeto.projetolistacompras.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetolistacompras.Entidade.ListaDeCompras;
import com.projeto.projetolistacompras.service.ListaDeComprasService;

@RestController
@RequestMapping
public class ListaDeComprasController {

	@Autowired
	private ListaDeComprasService listaDeComprasService;
	
	
	
	//criando uma lista nova
	@PostMapping("/criar-lista")
	public ResponseEntity<String> criarListaNova(@RequestBody ListaDeCompras lista){
		listaDeComprasService.salvar(lista);
		return ResponseEntity.status(HttpStatus.CREATED).body("Lista criada com Sucesso!!");
		}
	
	
	//Buscando lista por email
	@GetMapping("/buscar/{email}")
	public ResponseEntity<List<ListaDeCompras>> buscarPorEmail(@PathVariable String email){
		List<ListaDeCompras> listas = listaDeComprasService.buscarPorEmail(email);
		return ResponseEntity.ok(listas);
	}
	
	
	//Editar lista 
	@PutMapping("/editar-lista")
	public ResponseEntity<ListaDeCompras> editarListas(@RequestBody ListaDeCompras listaAtualizada){
	ListaDeCompras	listaEditada = listaDeComprasService.editar(listaAtualizada);
		return ResponseEntity.ok(listaEditada);		
	}
	
	//Excluir lista
	@DeleteMapping

}
