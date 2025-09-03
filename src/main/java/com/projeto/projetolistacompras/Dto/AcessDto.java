package com.projeto.projetolistacompras.Dto;

public class AcessDto {
	
	
	private String token;
	
	
	
	//constutor 
	public UsuarioDto(Usuario usuario) {
	
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
