package com.projeto.projetolistacompras.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.projetolistacompras.Entidade.ListaDeCompras;

public interface ListaDeComprasRepository extends JpaRepository<ListaDeCompras, Long>{
   
	List<ListaDeCompras> findByUsuarioEmail(String email); 
	
	Optional<ListaDeCompras> findByNomeLista(String nomeLista);
}
