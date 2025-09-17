package com.projeto.projetolistacompras.Dto;

import java.util.List;

public class ListaDeComprasDto {
	
	private String nome;
	private String descriçao;
	private List<ItemDto> itens;
	
	
	
	
	
	
	///getters e setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescriçao() {
		return descriçao;
	}
	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}
	public List<ItemDto> getItens() {
		return itens;
	}
	public void setItens(List<ItemDto> itens) {
		this.itens = itens;
	}
	
	
	
	
	
	

}
