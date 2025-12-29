package com.projeto.projetolistacompras.Entidade;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class ListaDeCompras {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private long id;


private String nome; 
private String descricao;



@ManyToOne
@JoinColumn(name = "usuario_id") 
private Usuario usuario; 

@ElementCollection(fetch = FetchType.EAGER) 
@CollectionTable(
	name = "lista_de_compras_itens",
	joinColumns = @JoinColumn(name = "lista_id")
)    //ajuste
private List<Item> itens = new ArrayList<>();


//Getters / Setters


public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nomeLista) {
	this.nome = nomeLista;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public List<Item> getItens() {
	return itens;
}

public void setItens(List<Item> itens) {
	this.itens = itens;
}









	
	
	
	
}
