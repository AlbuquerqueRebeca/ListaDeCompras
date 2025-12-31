package com.projeto.projetolistacompras;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto.projetolistacompras.Entidade.Usuario;
import com.projeto.projetolistacompras.Repository.UsuarioRepository;

@SpringBootTest
public class UsuarioTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test  //criando um usuario em memoria
	void deveSalvarERecuperarUsuario() {
      Usuario u = new Usuario();
	  u.setNome("Rebeca");  //nome de usuario
      u.setEmail("rebeca@gmail.com");  //email de usuario

	  usuarioRepository.save(u); //salvando usuario no banco de dados

	}

}

