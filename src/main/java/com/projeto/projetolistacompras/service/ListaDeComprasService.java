package com.projeto.projetolistacompras.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Dto.ListaDeComprasDto;
import com.projeto.projetolistacompras.Entidade.Item;
import com.projeto.projetolistacompras.Entidade.ListaDeCompras;
import com.projeto.projetolistacompras.Entidade.Usuario;
import com.projeto.projetolistacompras.Repository.ListaDeComprasRepository;
import com.projeto.projetolistacompras.Repository.UsuarioRepository;

@Service
public class ListaDeComprasService {
	
	private final ListaDeComprasRepository listaDeComprasRepository; 
	private final UsuarioRepository usuarioRepository; 
	
	
	
	public ListaDeComprasService(ListaDeComprasRepository listaDeComprasRepository, UsuarioRepository usuarioRepository ) {
		this.listaDeComprasRepository = listaDeComprasRepository; 
		this.usuarioRepository = usuarioRepository; 
	}
	
	public ListaDeCompras criarLista(String email, ListaDeCompras lista) {
		return usuarioRepository.findByEmail(email).map(usuario -> {
		lista.setUsuario(usuario); 
		return listaDeComprasRepository.save(lista);
		}) 
		.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}
	
	public List<ListaDeCompras> listarPorUsuario(String email){
		return listaDeComprasRepository.findByUsuarioEmail(email);
	}
	
	@SuppressWarnings("null")
	public void excluirLista(Long listaId) {
		listaDeComprasRepository.deleteById(listaId);
	}
	
	public List<ListaDeCompras> buscarPorEmail(String email){
		return listaDeComprasRepository.findByUsuarioEmail(email);
	}
	
	@SuppressWarnings("null")
	public void salvar(ListaDeCompras lista) {
		listaDeComprasRepository.save(lista);
	}

	@SuppressWarnings("null")
	public ListaDeCompras editar(ListaDeCompras listaAtualizada) {
		return listaDeComprasRepository.save(listaAtualizada);
	}
	
	public void salvarDto(ListaDeComprasDto dto, String email) {
		ListaDeCompras lista = converterDtoParaEntidade(dto);
		Usuario usuario = usuarioRepository.findByEmail(email)
			.orElseThrow(() -> new RuntimeException("Usuario não encontrado"));	
		   
		lista.setUsuario(usuario);
		listaDeComprasRepository.save(lista);
		
	}
	
	private ListaDeCompras converterDtoParaEntidade(ListaDeComprasDto dto) {
	    ListaDeCompras lista = new ListaDeCompras();

	    
	    lista.setNome(dto.getNome());

	   
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
	
	public void editarDto(ListaDeComprasDto dto, String email) {
	    ListaDeCompras lista = listaDeComprasRepository.findByNome(dto.getNome())
	        .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

		List<Item> itensConvertidos = dto.getItens().stream()
			.map(itemDto -> {
				Item item = new Item();
				item.setNome(itemDto.getNome());
				item.setQuantidade(itemDto.getQuantidade());
				return item;
			})
			.collect(Collectors.toList());

		lista.setItens(itensConvertidos);

	    listaDeComprasRepository.save(lista);
	}
	
	        
	        
	        
	    
	 }
	
	


