package com.projeto.projetolistacompras.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.projetolistacompras.Entidade.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
	 Optional<String>
}
