package poobtriz.buffos;

import java.awt.*;

public class Slow extends Buffo{

    public Slow(){
        super(new Color(60, 229, 4));
    }

    @Override
    public int accion() {
        return 3;
    }
}