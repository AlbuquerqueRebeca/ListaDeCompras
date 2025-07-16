package com.projeto.projetolistacompras.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return ResponseEntity.ok(HttpStatus.CREATED)	}
	
	
	
	

}
