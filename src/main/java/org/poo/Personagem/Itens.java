package org.poo.Personagem;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Itens {
    private String nome;
    private String descriçao;
    private String raridade;
    private double forcaItem;
    private double velocidadeItem;

    public AtributosCalculados getAtributosCalculados() {
        double forcaCalculada = this.forcaItem;
        double velocidadeCalculada = this.velocidadeItem;

        switch (this.raridade){
            case "comum":
                forcaCalculada *= 1.5;
                velocidadeCalculada *= 1.5;
                break;
            case "raro":
                forcaCalculada *= 3.5;
                velocidadeCalculada *= 2.5;
                break;
            case "lendario":
                forcaCalculada *= 5.5;
                velocidadeCalculada *= 4.5;
                break;
            default:
                forcaCalculada *= 1.5;
                velocidadeCalculada *= 1.5;
        }
        return new AtributosCalculados(forcaCalculada, velocidadeCalculada);
    }

    @Getter
    public static class AtributosCalculados{
        private final double forca;
        private final double velocidade;

        public AtributosCalculados(double forca, double velocidade){
            this.forca = forca;
            this.velocidade = velocidade;
        }

    }

}
