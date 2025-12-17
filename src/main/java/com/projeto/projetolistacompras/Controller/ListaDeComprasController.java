package com.projeto.projetolistacompras.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetolistacompras.Dto.ListaDeComprasDto;
import com.projeto.projetolistacompras.Entidade.Item;
import com.projeto.projetolistacompras.Entidade.ListaDeCompras;
import com.projeto.projetolistacompras.Repository.UsuarioRepository;
import com.projeto.projetolistacompras.service.ListaDeComprasService;
import com.projeto.projetolistacompras.service.RecommendationService;

@RestController
@RequestMapping("/auth")
public class ListaDeComprasController {

	
	
	@Autowired
	private ListaDeComprasService listaDeComprasService;
	
	@Autowired	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RecommendationService recommendationService;
	
	//@Autowired
	//private UsuarioService usuarioService; 
	
	
	//criando uma lista nova
	@PostMapping("/criar-lista")
	public ResponseEntity<String> criarListaNova(@RequestBody ListaDeComprasDto listaDto){
		ListaDeCompras lista = converterDtoParaEntidade(listaDto);
		listaDeComprasService.salvar(lista);
		return ResponseEntity.status(HttpStatus.CREATED).body("Lista criada com Sucesso!! Boas compras");
		}
	
	private ListaDeCompras converterDtoParaEntidade(ListaDeComprasDto dto) {
	    ListaDeCompras lista = new ListaDeCompras();
	    lista.setNome(dto.getNome());
	    lista.setDescricao(dto.getDescricao());

	    List<Item> itensConvertidos = dto.getItens().stream() 
	    	    .map(itemDto -> {
	    	        Item item = new Item();
	    	        item.setNome(itemDto.getNome());
	    	        item.setQuantidade(itemDto.getQuantidade());
	    	        return item;
	    	    })
	    	    .collect(Collectors.toList());

	    	lista.setItens(itensConvertidos);
	    	return lista;
	}
	//Buscando lista por email
	@GetMapping("/buscar/{email}")
	public ResponseEntity<List<ListaDeCompras>> buscarPorEmail(@PathVariable String email){
		List<ListaDeCompras> listas = listaDeComprasService.buscarPorEmail(email);
		return ResponseEntity.ok(listas);
	}
	
	
	//Editar lista 
	@PutMapping("/editar-lista")
	public ResponseEntity<String> editarListas(@RequestBody ListaDeComprasDto listaDto){
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String email = userDetails.getUsername();
	listaDeComprasService.editarDto(listaDto, email);	
	return ResponseEntity.ok("Lista editada com sucesso!!");		
	}
	
	//Excluir lista
	
	@DeleteMapping("/deletar-lista")
	public ResponseEntity<String> excluindoLista(){
			   UserDetails userDetails = (UserDetails) SecurityContextHolder
			                   .getContext()
							   .getAuthentication()
							   .getPrincipal();

				String email = userDetails.getUsername();
				listaDeComprasService.excluirLista(email);	
				
				return ResponseEntity.ok("Listas deletadas com sucesso!!");
							
							
	}
	

   //sugestao de produtos
   @GetMapping("/sugestaoes/{email}")
   public ResponseEntity<List<String>> obterSugestoes(@PathVariable String email) {
	List<String> sugestoes = recommendationService.sugerirItens(email);
	return ResponseEntity.ok(sugestoes);
   }

}