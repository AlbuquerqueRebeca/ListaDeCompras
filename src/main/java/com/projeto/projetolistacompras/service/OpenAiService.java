package com.projeto.projetolistacompras.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAiService {

    @Value("${openai.api.key}") 
    private String apikey;

    //injeção de dependencia
    private final RestTemplate restTemplate;
}
