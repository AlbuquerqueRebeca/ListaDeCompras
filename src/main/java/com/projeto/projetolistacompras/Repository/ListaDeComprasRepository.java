package com.projeto.projetolistacompras.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.projetolistacompras.Entidade.ListaDeCompras;

public interface ListaDeComprasRepository extends JpaRepository<ListaDeCompras, Long>{
    List<ListaDeCompras> findByUsuarioId(Long UsuarioId);
}
