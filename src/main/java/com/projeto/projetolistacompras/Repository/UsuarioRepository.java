package com.projeto.projetolistacompras.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projetolistacompras.Entidade.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
	 Optional<Usuario> findByEmail(String email);
	 
	 Optional<Usuario> findByLogin(String login);
}
