package com.projeto.projetolistacompras.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projeto.projetolistacompras.Entidade.Item;
import com.projeto.projetolistacompras.Entidade.ListaDeCompras;
import com.projeto.projetolistacompras.Repository.ListaDeComprasRepository;

@Service
public class RecommendationService {

    private final ListaDeComprasRepository listaDeComprasRepository; 

    public RecommendationService(ListaDeComprasRepository listaDeComprasRepository) {
    this.listaDeComprasRepository = listaDeComprasRepository; 
    }
    //busca todas as listas
    public List<String> sugerirItens(String email) {
        System.out.println("ENTROU NO METODO SUGERIRiTENS");  //log
    List<ListaDeCompras> historico = listaDeComprasRepository.findByUsuarioEmailWithItens(email); 
    
      
   //extrai todos os itens
    List<Item> itens = historico.stream() 
        .flatMap(lista -> lista.getItens().stream())
        .collect(Collectors.toList());
        System.out.println("ITENS COLETADOS: " + itens);    //log


     //conta a frequencia de itens
     Map<String, Long> frequencia = itens.stream()
     .collect(Collectors.groupingBy(Item::getNome, Collectors.counting()));
     System.out.println("FREQUENCIA:  " + frequencia);     //log
     
     return frequencia.entrySet().stream()
        .filter(e -> e.getValue() > 2 )
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
     
    }

}