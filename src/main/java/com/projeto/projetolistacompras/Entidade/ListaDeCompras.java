package com.projeto.projetolistacompras.Entidade;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
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


private String nomeLista; 

@ManyToOne
@JoinColumn(name = "usuario_id") 
private Usuario usuario; 

@ElementCollection 
private List<String>itens;



//Getters / Setters


public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNomeLista() {
	return nomeLista;
}

public void setNomeLista(String nomeLista) {
	this.nomeLista = nomeLista;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

public List<String> getItens(){
	return itens;
}
	


public void setItens(List<String> itens) {
	this.itens = itens;
} 







	
	
	
	
}
