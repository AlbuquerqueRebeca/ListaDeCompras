package com.projeto.projetolistacompras.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<String> criarListaNova(@RequestBody ListaDeComprasDto listaDto, Authentication authentication){
		String email = authentication.getName();
		listaDeComprasService.salvarDto(listaDto, email);
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
	//Buscando listas
	@GetMapping("/buscar")
	public ResponseEntity<List<ListaDeCompras>> buscarPorEmail(Authentication authentication){
		String email = authentication.getName(); //pega token jwt
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
                  System.out.println("EMAIL EXTRAIDO DO TOKEN " + email);

                 usuarioRepository.findByEmail(email).ifPresentOrElse(
					     u -> System.out.println("USUARIO ENCONTRADO: " + u.getEmail()),
						() -> System.out.println("NENHUM USUARIO ENCONTRADO COM ESSE EMAIL NO BANCO")				
					 );
				     

				
				listaDeComprasService.excluirLista(email);	
				return ResponseEntity.ok("Listas deletadas com sucesso!!");
							
							
	}
	

   //sugestao de produtos
	@GetMapping("/sugestoes")
	public ResponseEntity<List<String>> obterSugestoes(Authentication authentication) {
	 String email = authentication.getName();
	 List<String> sugestoes = recommendationService.sugerirItens(email);
	 return ResponseEntity.ok(sugestoes);
	}

	   //associa listas sem usuario (para uso de manutençao)
	   @PostMapping("/associar-listas")
	   public ResponseEntity<String> associarListas(Authentication authentication) {
		   String email = authentication.getName();
		   int qtd = listaDeComprasService.associarListasSemUsuarioPara(email);
		   return ResponseEntity.ok("Listas associadas: " + qtd);
	   }

}