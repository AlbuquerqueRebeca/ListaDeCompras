package com.projeto.projetolistacompras.service;

import java.net.http.HttpHeaders;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
      headers.setBearerAuth(apiKey); //autenticação com a chave da api

     HttpEntity<String> request = new HttpEntity<>(body, headers);

     

     String retorno = restTemplate.postForObjetct(
        "https://api.openai.com/v1/chat/completion",
        entity,
        String.class
     );

   
       }




}
