package com.projeto.projetolistacompras.Entidade;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity  
public class Usuario {
	

@Id
@Column(unique = true) 
private String email;


private String nome; 
private String login;
private String senha; 


@OneToMany(mappedBy = "usuario", cascade =  CascadeType.ALL, orphanRemoval = true )
private List<ListaDeCompras>listaDeCompras;


public Usuario() { 
	
}

     
     
	public Usuario(String nome, String senha) { 
		this.nome = nome; 
		this.senha = senha;
		this.email = email;
		
	}
	
	//getters / setters 
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void  setLogin(String login) {
		
	}
	
	
	public List<ListaDeCompras> getListaDeCompras() {
		return listaDeCompras;
	}
	public void setListaDeCompras(List<ListaDeCompras> listaDeCompras) {
		this.listaDeCompras = listaDeCompras;
	}

	
	



	
	

	
	
	
	
	
	
	
	

}
