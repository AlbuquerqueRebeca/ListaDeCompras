package com.projeto.projetolistacompras;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto.projetolistacompras.Repository.UsuarioRepository;

@SpringBootTest
public class UsuarioTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	void contextLoads() {
	}

}

