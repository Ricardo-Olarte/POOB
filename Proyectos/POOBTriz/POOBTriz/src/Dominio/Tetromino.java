package Dominio;

import java.awt.Color;

/**
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-1
 */
public class Tetromino {

    private int[][] tipo;
    private Color color;
    private int x;
    private int y;
    private int[][][] tipos;
    private int posicionActual;

    /**
     * Constructor de Tetromino
     * @param tipo
     * @param color
     */
    public Tetromino(int[][] tipo, Color color){
        this.tipo = tipo;
        this.color = color;
        tiposIniciales();
    }

    /**
     *
     */
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

    /**
     *
     * @param anchoCelda
     */
    public void generarTetromino(int anchoCelda){
        posicionActual = 0;
        tipo = tipos[posicionActual];
        y = - getAltura();
        x = (anchoCelda - getAncho())/ 2;
    }

    /**
     *
     * @return
     */
    public int[][] getTipo(){
        return tipo;
    }

    /**
     *
     * @return
     */
    public Color getColor(){
        return color;
    }

    /**
     *
     * @return
     */
    public int getAltura(){
        return tipo.length;
    }

    /**
     *
     * @return
     */
    public int getAncho(){
        return tipo[0].length;
    }

    /**
     *
     * @return
     */
    public int getX(){
        return x;
    }

    /**
     *
     * @return
     */
    public int getY(){
        return y;
    }

    /**
     * Aumenta en y, mover Abajo
     */
    public void moverAbajo(){
        y++;
    }

    /**
     * Aumenta en x, mover Derecha
     */
    public void moverDerecha(){
        x++;
    }

    /**
     * Disminuye en x, mover Izquierda
     */
    public void moverIzquierda(){
        x--;
    }

    /**
     *
     * @return
     */
    public int getFondo(){
        return y + getAltura();
    }

    /**
     * Rota el tetromino
     */
    public void rotar(){
        posicionActual++;
        if(posicionActual > 3) posicionActual = 0;
        tipo = tipos[posicionActual];
    }

    /**
     *
     * @return
     */
    public int getIzq(){
        return x;
    }

    /**
     *
     * @return
     */
    public int getDer(){
        return x + getAncho();
    }

}
