package com.projeto.projetolistacompras.service;

import java.util.List;

import com.projeto.projetolistacompras.Entidade.ListaDeCompras;
import com.projeto.projetolistacompras.Repository.ListaDeComprasRepository;

public class RecommendationService {

    private final ListaDeComprasRepository listaDeComprasRepository; 

    public RecommendationService(ListaDeComprasRepository listaDeComprasRepository) {
    this.listaDeComprasRepository = listaDeComprasRepository; 
    }

    public List<String> sugerirItens(String email) {
    List<ListaDeCompras> historico = listaDeComprasRepository.findByUsuarioEmail(email);
    }

}