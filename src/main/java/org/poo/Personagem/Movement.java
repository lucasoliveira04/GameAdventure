package org.poo.Personagem;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Movement {
    private int x;
    private int y;

    public Movement(){
        
    }

    public Movement(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
