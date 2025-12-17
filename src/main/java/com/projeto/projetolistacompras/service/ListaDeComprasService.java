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

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ListaDeComprasService {
	
	private final ListaDeComprasRepository listaDeComprasRepository; 
	private final UsuarioRepository usuarioRepository; 
	
	
	
	public ListaDeComprasService(ListaDeComprasRepository listaDeComprasRepository, UsuarioRepository usuarioRepository ) {
		this.listaDeComprasRepository = listaDeComprasRepository; 
		this.usuarioRepository = usuarioRepository; 
	}
	
	//criando lista de compras
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
	
	//excluindo lista de compras
	@Transactional
	public void excluirLista(String email) {
		if(!usuarioRepository.existsById(email)){
			throw new EntityNotFoundException("Usuário não encontrado com esse email:   " + email);
		}
           ListaDeComprasRepository.deleteAllByUsuarioEmail(email);
		}
	
	
	public List<ListaDeCompras> buscarPorEmail(String email){
		return listaDeComprasRepository.findByUsuarioEmail(email);
	}
	//salvando a lista
	@SuppressWarnings("null")
	public void salvar(ListaDeCompras lista) {
		listaDeComprasRepository.save(lista);
	}
    //editando a lista de compras 
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
	
	


