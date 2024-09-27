package org.poo.Personagem;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Personagem {
    private int vida = 100;
    private int energia = 100;
    private int forcaAtaque = 10;
    private int velocidade = 5;
    private int itens;
    private List<Integer> qntdAtaques;


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
    }

}
