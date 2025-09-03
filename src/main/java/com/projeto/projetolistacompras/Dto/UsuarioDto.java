package com.projeto.projetolistacompras.Dto;

import com.projeto.projetolistacompras.Entidade.Usuario;

public class UsuarioDto {
	
	
	  
	   public String email;
	   public String nome;
	   public String login;
	   public String senha;
	   
	   
	   public UsuarioDto(Usuario usuario) {
		this.email = usuario.getEmail();
		this.nome = usuario.getNome();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
	   }
	   
	   
	   
	   public String getEmail() {
		   return email; 
	   }
	   
	   public void setEmail(String email) {
		 this.email = email;
	   }
	   
	   
	   public String getNome() {
		   return nome;
	   }
	   
	   public void setNome(String nome) {
		   this.nome = nome;
	   }
	   
	   public String getLogin() {
		   return login;
		}
	   
	   public void setLogin(String login) {
		 this.login = login;  
	   }
	   
	   public String getSenha() {
		   return senha;
	   }
	   
	   public void setSenha(String senha) {
		 this.senha = senha;
	   }
	   
	
	
	
	
	
	
	
	
	
	
	
	
	

}
