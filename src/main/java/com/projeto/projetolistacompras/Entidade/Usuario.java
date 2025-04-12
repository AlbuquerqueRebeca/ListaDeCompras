package com.projeto.projetolistacompras.Entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  
public class Usuario {
	

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY )
private long id; 

private String nome;
@Column(unique = true) 
private String email; 
private String senha; 

	
	

	
	
	
	
	
	
	
	

}
