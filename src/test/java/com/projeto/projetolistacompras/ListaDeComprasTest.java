package com.projeto.projetolistacompras;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;



@SpringBootTest
@AutoConfigureMockMvc

public class listaDeComprasTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private com.projeto.projetolistacompras.service.RecommendationService recommendationService;



    @Test
    @WithMockUser(username = "rebeca@gmail.com")
    void deveRetornarSugestoesDeProduto() throws Exception {
        when(recommendationService.sugerirItens("rebeca@gmail.com"))
            .thenReturn(List.of("Arroz", "feijão", "café"));

        mockMvc.perform(get("/auth/sugestoes"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0]").value("Arroz"))
            .andExpect(jsonPath("$[1]").value("Feijão"))
            .andExpect(jsonPath("$[2]").value("Café"));
          
             }

      @Test
      @WithMockUser(username = "rebeca@gmail.com")
      void deveCriarListaNova() throws Exception {
            String listaJson = """
                    {
                        "nome": "Lista da semana"
                        "descriçao: "Itens para abastecer a casa"
                        "Itens":  [
                           {"nome": "Arroz", "quantidade": 1},
                           {"nome": "Café", "quantidade": 2},
                          {"nome": "Feijão", "quantidade": 3}                     
                        
        ] 
                        }
                    """;

            




      }


    
    
}
