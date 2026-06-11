package com.projeto.projetolistacompras.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class openAiService {

    @Value("${openai.api.key}")
    private String apiKey;
    
    //injeção de dependencia
    private final RestTemplate restTemplate;
    public openAiService(RestTemplate restTemplate){
         this.restTemplate = restTemplate;
    }

       public String gerarSugestao(List<String> itens){  
    
         //montar prompet (exemplos de prompets ) //buscar por exemplos de prompets 
            String prompt = """
             Você é um assitente de compras inteligente.
            O usuário possui os seguintes itens em casa: %s
            Com base nesses itens, sugira entre 5 e 10 produtos complementares para uma receita.
            sugira uma receita faácil e prática de fazer.
            Não repita itens já existentes.
            analise os ingredientes informados.
            Responda em  português e em tópicos, com explicações adicionais para cada sugestão. "
                              
                    """.formatted(String.join(", ", itens));
   
        // criar headers (informaçoes tecnicas que vão junto da requisiçao HTTP)
            HttpHeaders headers = new HttpHeaders(); //inicializando
            headers.setContentType(MediaType.APPLICATION_JSON); // enviando dados em formato json
            headers.setBearerAuth(apiKey); // autenticaçao 

            //simulando uma requisiçao HTTP POST autenticada (corpo em formato json e os headers)
            HttpEntity<String> entity = new HttpEntity<>("{\"item\":\"arroz\"}", headers);
           //trocar a URL AQUI >>>>>>>>>>>>>>>>>>
           String response = restTemplate.postForObject("https://sua-api.com/sugestao", entity, String.class);
           System.out.println(response);


        //criar body json
        //enviar post para openai

        //receber resposta (em linguagem natural)
        //retornar texto






       }

    }

