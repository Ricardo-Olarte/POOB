package poobtriz.buffos;

import java.awt.*;

public class StopT extends Buffo{

    public StopT(){
        super(new Color(255, 221, 0));
    }

    @Override
    public int accion() {
        return 1;
    }
}