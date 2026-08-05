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
public class OpenAiService {

    @Value("${openai.api.key}") 
    private String apikey;

    //injeção de dependencia
    private final RestTemplate restTemplate;
    public OpenAiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate; 
    }

       public String gerarSugestao(List<String> itens){



        //prompet
        String prompt = """
        Você é um assitente de compras inteligente.
        O usuário possui os seguintes itens em casa: %s
        Com base nesses itens sugerir entre 5 e 10 produtos complementares
        Não repita itens já existentes.
        Analise os ingredientes informados.
        Responda em português e em tópicos, com explicações adicionais para 
        cada sugestão."      
               
                     """.formatted(String.join(", ", itens));


        //corpo da requisição
        String  body = """ 
        {
        "model": "gpt-40-,mini",
         "messagens":[
         {
           "role": "system", "content": "Você é um assitente de compras inteligente." },
         {
           "role": "user", "content": "%s"
         } ],
             "temperature": 0.7 
        
       }
        """.formatted(prompt);

      //adicionando headers 
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON); //enviando dados em formato json
      headers.setBearerAuth(apikey); //autenticação com a chave da api

     HttpEntity<String> entity = new HttpEntity<>(body, headers);

     
     //enviando a requisiçao e trazendo resposta 
     String retorno = restTemplate.postForObject(
        "https://api.openai.com/v1/chat/completion",
        entity,
        String.class
     );
     
     //extraindo texto da resposta
     try{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(retorno);
        String response = root.path("choices").get(0).path("message").path("content").asText();
        return response;
       }catch(Exception e){  //tratamento de exceção
        e.printStackTrace();
        return "Erro ao gerar sugestão";
       }



   
       }




}
