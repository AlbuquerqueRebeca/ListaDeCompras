package com.projeto.projetolistacompras.Entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class ListaDeCompras {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private long id;


private String nomeLista; 

	
	
	
	
}
