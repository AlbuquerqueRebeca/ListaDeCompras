package com.projeto.projetolistacompras.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class openAiService {

    @Value("${openai.api.key}")
    private String apiKey;
    
    //injeção de dependencia
    private final RestTemplate restTemplate;
    public openAiService(RestTemplate restTemplate){
         this.restTemplate = restTemplate;
    }

       public String gerarSugestao(List<String> itens){  
    
         //montar prompet 
            String prompt = """
             Você é um assitente de compras inteligente.
            O usuário possui os seguintes itens em casa: %s
            Com base nesses itens, sugira entre 5 e 10 produtos complementares para uma receita.
            sugira uma receita faácil e prática de fazer.
            Não repita itens já existentes.
            analise os ingredientes informados.
            Responda em  português e em tópicos, com explicações adicionais para cada sugestão. "
                              
                    """.formatted(String.join(", ", itens));
   
        
        //corpo da requisiçao HTTP // o que quero enviar no corpo da requisição
           String body = """
           {
            "model": "gpt-40-mini",  //modelo mais recente , mais rapido e mais barato
            "messages": [
            {
                "role": "system", "content": "Você é um assistente de compras inteligente." },
            {
                 "role": "user", "content": "%s"
                } ],
                 "temperature": 0.7  // controla a criatividade da resposta
         
         }
               """.formatted(prompt);

               // criando headers (informaçoes tecnicas que vão junto da requisiçao HTTP)
            HttpHeaders headers = new HttpHeaders(); //inicializando
            headers.setContentType(MediaType.APPLICATION_JSON); // enviando dados em formato json
            headers.setBearerAuth(apiKey); // autenticaçao 

            HttpEntity<String> entity = new HttpEntity<>(body, headers); //criando a entidade

        //enviar a requisiçao para o endpoint correto da openai
        //enviando a requsição e trazendo resposta 
        String retorno = restTemplate.postForObject(
         "http://api.openai.com/v1/chat/completion",
         entity,
         String.class
        );
        //estraindo texto da resposta
        try{
         ObjectMapper mapper = new ObjectMapper();
         JsonNode root = mapper.readTree(retorno);
         String response =  root.path("choices").get(0).path("message").path("content").asText();
         return response;
        }catch(Exception e){
         e.printStackTrace();
         return "Erro ao gerar sugestão";
        }


         
        






       }

    }

