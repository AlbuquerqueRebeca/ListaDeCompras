package com.projeto.projetolistacompras.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.projetolistacompras.Entidade.ListaDeCompras;



public interface ListaDeComprasRepository extends JpaRepository<ListaDeCompras, Long>{
   
	List<ListaDeCompras> findByUsuarioEmail(String email); 
	
	Optional<ListaDeCompras> findByNome(String nome);


	@Query("SELECT l FROM LISTADECOMPRAS l JOIN FETCH l.itens WHERE l.usuario.email = :email")
	List<ListaDeCompras> findByUsuarioEmailWithItens(@Param ("email")String email);


	
}
