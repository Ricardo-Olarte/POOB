package poobtriz.buffos;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public abstract class Buffo implements Serializable {
    private Color color;
    protected int x, y;

    public Buffo(Color color) {
        this.color = color;
        Random r = new Random();
        x = r.nextInt(10);
        y = r.nextInt(2) + 2;
    }

    public abstract int accion();

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Color getColor() {
        return color;
    }
}