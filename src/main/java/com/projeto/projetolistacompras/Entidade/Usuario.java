package com.projeto.projetolistacompras.Entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity  
public class Usuario {
	

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY )
private long id; 

private String nome;
@Column(unique = true) 
private String email; 
private String senha; 


@OneToMany(mappedBy = "usuario", cascade =  CascadeType.All, orphanRemoval = true )


	
	

	
	
	
	
	
	
	
	

}
