package com.projeto.projetolistacompras;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.projeto.projetolistacompras.service.RecommendationService;

@SpringBootTest
@AutoConfigureMockMvc
public class criarListaTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecommendationService recommendationService;

    @Test
    @WithMockUser(username = "rebeca@gmail.com")
    void deveCriarListaNova() throws Exception {
        String listaJson = """
                {
                     "nome": "lista de compras semanal",
                     "descricao": "Lista de compras para a semana",
             "itens": [
                         {"nome": "Arroz", "quantidade": 2},
                         {"nome": "Feijao", "quantidade": 3},
                         {"nome": "Café", "quantidade": 1}
                         ]
                         
                         }
                """;
        mockMvc.perform(post("/auth/criar-lista")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(listaJson))
                        .andExpect(status().isCreated())
            .andExpect(content().string("Lista criada com Sucesso!! Boas compras"));
            
            
            
    

    }

    
}
