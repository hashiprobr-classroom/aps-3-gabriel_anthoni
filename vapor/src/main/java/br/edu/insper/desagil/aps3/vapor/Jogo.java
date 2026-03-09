package br.edu.insper.desagil.aps3.vapor;

import java.util.HashMap;
import java.util.Map;

public class Jogo {
    private int id;
    private String nome;
    private Map<String, Integer> avaliacoes;

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public Jogo(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.avaliacoes = new HashMap<>();
    }

    public void avalia(String apelido, int avaliacao){
        avaliacoes.put(apelido, avaliacao);
    }

    public boolean avaliado(String apelido){
        return avaliacoes.containsKey(apelido);
    }

    public double media(){
        double soma = 0.0;
        for(int avaliacao:avaliacoes.values()){
            soma += avaliacao;
        }
        if (avaliacoes.isEmpty()){
            return 0.0;
        }
        int contagem = avaliacoes.size();
        return soma/contagem;

    }

}
