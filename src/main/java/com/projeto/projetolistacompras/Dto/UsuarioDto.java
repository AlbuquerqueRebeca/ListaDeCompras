package com.projeto.projetolistacompras.Dto;

import org.springframework.beans.BeanUtils;

import com.projeto.projetolistacompras.Entidade.Usuario;

public class UsuarioDto {
	
	
	  
	   public String email;
	   public String nome;
	   public String login;
	   public String senha;
	   
	   
	   @SuppressWarnings("null")
	   public UsuarioDto(Usuario usuario) {
		BeanUtils.copyProperties((Object) usuario, this);
	   }
	   
	   
	   public UsuarioDto() {
		   
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
