package com.projeto.projetolistacompras.Dto;

import java.util.List;

public class ListaDeComprasDto {
	
	private String nome;
	private String descricao;
	private List<ItemDto> itens;
	
	
	
	
	
	
	///getters e setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descriçao) {
		this.descricao = descricao;
	}
	public List<ItemDto> getItens() {
		return itens;
	}
	public void setItens(List<ItemDto> itens) {
		this.itens = itens;
	}
	
	
	
	
	
	

}
