package com.projeto.projetolistacompras;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.projeto.projetolistacompras.service.RecommendationService;

@SpringBootTest
@AutoConfigureMockMvc


 class sugestoesTest {

    @Autowired
    private MockMvc mockMvc;

   @MockBean
    private RecommendationService recommendationService;


    @Test
    @WithMockUser(username = "rebeca@gmail.com")
    void deveRetornarSugestoesDeProduto()  throws Exception {
          when(recommendationService.sugerirItens("rebeca@gmail.com"))
             .thenReturn(Arrays.asList("Banana","Arroz","Feijao","Café"));

          mockMvc.perform(get("/auth/sugestoes")) 
         .andExpect(status().isOk())
         .andExpect(jsonPath("$[1]").value("Arroz"))
         .andExpect(jsonPath("$[2]").value("Feijao"))
         .andExpect(jsonPath("$[3]").value("Café"));

    }
    
}
