package com.projeto.projetolistacompras.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Entidade.ListaDeCompras;
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
	
	public ListaDeCompras criarLista(Long usuarioId, ListaDeCompras lista) {
		return usuarioRepository.findById(usuarioId).map(usuario -> {
		lista.setUsuario(usuario); 
		return listaDeComprasRepository.save(lista);
		}) 
		.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}
	
	public List<ListaDeCompras> listarPorUsuario(Long usuarioId){
		return listaDeComprasRepository.findByUsuarioId(usuarioId);
	}
	
	public void excluirLista(Long listaId) {
		
	}

	

}
