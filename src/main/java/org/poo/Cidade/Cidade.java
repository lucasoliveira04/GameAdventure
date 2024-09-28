package org.poo.Cidade;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Cidade {
    private String nome;
    private double tamanho;
    private int populacao;
    private int qntdItens;
    private List<Integer> localizacaoItens;
    private List<Double> localizacaoPersonagens;

    public Cidade(){
        this.localizacaoItens = new ArrayList<>();
        this.localizacaoPersonagens = new ArrayList<>();
    }

    public void adicionarItem(int localizacao){
        localizacaoItens.add(localizacao);
        qntdItens++;
    }
    

    public void mostrarItens(){
        for (int i = 0; i < qntdItens; i++){
            System.out.println("Item " + (i+1) + " está na localização " + localizacaoItens.get(i));
        }
    }

    public void mostrarPersonagem(){
        for (int i = 0; i < localizacaoPersonagens.size(); i++){
            System.out.println("Personagem está na localização " + localizacaoPersonagens.get(i));
        }
    }
}
