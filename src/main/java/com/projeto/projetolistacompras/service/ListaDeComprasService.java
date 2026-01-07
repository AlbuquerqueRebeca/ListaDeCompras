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
		Usuario usuario = usuarioRepository.findByEmail(email)
		     .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com esse email:   " + email));
			 listaDeComprasRepository.deleteAll(usuario.getListaDeCompras());
		   

	}
	
	//buscando lista 
	public List<ListaDeCompras> buscarPorEmail(String email){
		return listaDeComprasRepository.findByUsuarioEmail(email);
	}
	//salvando a lista
	@SuppressWarnings("null")
	public void salvar(ListaDeCompras lista) {
		listaDeComprasRepository.save(lista);
	}

    //editando a lista de compras 
     public ListaDeCompras editar(ListaDeComprasDto dto, String email) {
		ListaDeCompras lista = listaDeComprasRepository.findById(dto.getId())
		  .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

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

	   
		
	
	public void editarDto(ListaDeComprasDto dto, String email) {
		ListaDeCompras lista = listaDeComprasRepository.findByNomeAndUsuarioEmail(dto.getNome(), email)
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

	@Transactional
	public int associarListasSemUsuarioPara(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email)
			.orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

		List<ListaDeCompras> listasSemUsuario = listaDeComprasRepository.findAll().stream()
			.filter(l -> l.getUsuario() == null)
			.collect(Collectors.toList());

		listasSemUsuario.forEach(l -> l.setUsuario(usuario));

		listaDeComprasRepository.saveAll(listasSemUsuario);

		return listasSemUsuario.size();
	}
	
	        
	        
	        
	    
	 }
	
	


