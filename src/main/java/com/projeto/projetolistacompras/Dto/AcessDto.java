package com.projeto.projetolistacompras.Dto;

import com.projeto.projetolistacompras.Entidade.Usuario;

public class AcessDto {
	
	
	private String token;
	
	
	
	//constutor 
	public UsuarioDto(Usuario usuario) {
	this.email = usuario.getEmail();
	}
	
	
	
	public AcessDto(String token) {
		super();
		this.token = token;
	}
	
	public String getToken() {
    return token;
	
	}
	
	public void setToken(String token) {
	this.token = token;
	
	}

}
