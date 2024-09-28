package org.poo.Personagem;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Personagem {
    private Long id;
    private String nome;
    private int vida = 100;
    private int energia = 100;
    private int forcaAtaque = 10;
    private int velocidade = 5;
    private int itens;
    private List<Integer> qntdAtaques;
    private List<Double> coordenadas;
    private int fase;
    private List<Itens> itensColetados;

    public Personagem(){
        this.coordenadas = new ArrayList<>();
        this.coordenadas.add(0.0);
        this.coordenadas.add(0.0);
        this.itensColetados = new ArrayList<>();
    }

    public boolean atacar() {
        if (this.energia > 0) {
            this.energia -= 10;
            return true;
        }
        return false;
    }

    public void coletarItem(Itens item) {
        this.energia += 5;
        this.forcaAtaque += item.getAtributosCalculados().getForca();
        this.velocidade += item.getAtributosCalculados().getVelocidade();
        this.itens++;
        this.itensColetados.add(item);
    }

    public void mover(Movement movimento) {
        if (this.energia > 0){
            this.energia -= 5;
            movimento.setX(movimento.getX() + 5);
            movimento.setY(movimento.getY() + 5);
            this.coordenadas.add(movimento.getX());
            this.coordenadas.add(movimento.getY());
        } else {
            System.out.println("Sem energia para se mover");
        }
    }

    public void mochila(){
        System.out.println("Mochila");
        System.out.println("Vida: " + this.vida);
        System.out.println("Energia: " + this.energia);
        System.out.println("Itens: " + this.itens);
        listarPorRaridade();
    }

    public void listarPorRaridade(){
        List<Itens> itensComum = new ArrayList<>();
        List<Itens> itensRaro = new ArrayList<>();
        List<Itens> itensLendario = new ArrayList<>();

        for (Itens item : itensColetados){
            switch (item.getRaridade()){
                case "comum":
                    itensComum.add(item);
                    break;
                case "raro":
                    itensRaro.add(item);
                    break;
                case "lendario":
                    itensLendario.add(item);
                    break;
            }
        }

        System.out.println("Itens comuns: ");
        for (Itens item : itensComum){
            System.out.println(item.getNome());
        }

        System.out.println("Itens raros: ");
        for (Itens item : itensRaro){
            System.out.println(item.getNome());
        }

        System.out.println("Itens lendários: ");
        for (Itens item : itensLendario){
            System.out.println(item.getNome());
        }
    }

}
