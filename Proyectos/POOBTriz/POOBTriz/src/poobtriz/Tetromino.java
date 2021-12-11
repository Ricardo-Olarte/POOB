package poobtriz;

import java.awt.Color;
import java.util.Random;

public class Tetromino {
    private int[][] tipo;
    public Color color;
    private int x;
    private int y;
    private int[][][] tipos;
    private int posicionActual;
    private Color[] colores = {Color.ORANGE, Color.CYAN, Color.BLUE, Color.PINK, 
    Color.RED, Color.YELLOW, Color.GREEN};
    
    public Tetromino(int[][] tipo){
        this.tipo = tipo;
        tiposIniciales();
    }
    
    public void tiposIniciales(){
        tipos = new int[4][][];
        for(int i = 0; i < 4; i++){
            int r = tipo[0].length;
            int c = tipo.length;
            tipos[i] = new int[r][c];
            for(int y = 0; y < r; y++){
                for(int x = 0; x < c; x++){
                    tipos[i][y][x] = tipo [c-x-1][y];
                }
         
            }
            tipo = tipos[i];
            
        }
    } 
    
    public void generarTetromino(int anchoCelda){
        Random r = new Random();
        posicionActual = r.nextInt(tipos.length);
        tipo = tipos[posicionActual];
        y = - getAltura();
        x = (anchoCelda - getAncho())/ 2;
    }
    
    public int[][] getTipo(){
        return tipo;
    }
    
    public Color getColor(){
        return color;
    }
    
    public int getAltura(){
        return tipo.length;
    }
    
    public int getAncho(){
        return tipo[0].length;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void moverAbajo(){
        y++;
    }
    
    public void moverDerecha(){
        x++;
    }
    
    public void moverIzquierda(){
        x--;
    }
    
    public int getFondo(){
        return y + getAltura();
    }
    
    public void rotar(){
        posicionActual++;
        if(posicionActual > 3) posicionActual = 0;
        tipo = tipos[posicionActual];
    }
    
    public int getIzq(){
        return x;
    }
    
    public int getDer(){
        return x + getAncho();
    }
    
    public void setX(int nuevoX){
        x = nuevoX;
    }
    
    public void setY(int nuevoY){
        y = nuevoY;
    }
    
}
