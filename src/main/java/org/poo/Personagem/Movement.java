package org.poo.Personagem;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Movement {
    private double x;
    private double y;

    public Movement(){
        
    }

    public Movement(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
