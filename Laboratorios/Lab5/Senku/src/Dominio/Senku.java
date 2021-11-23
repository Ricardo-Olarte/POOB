package Dominio;

import java.util.ArrayList;

/**
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-1
 */
public class Senku{

    private Tablero tablero;
    private ArrayList<Circulo> fichas;
    private Circulo ficha;

    /**
     * Cnostructor de senku
     */
    public Senku(){
        inicio();
    }

    /**
     * Inicia el juego
     */
    public void inicio(){
        tablero = new Tablero(7);
    }

    /**
     *
     * @param x
     * @param y
     * @param fx
     * @param fy
     * @throws SenkuExcepcion
     */
    public void refresque(int x, int y, int fx, int fy)throws SenkuExcepcion{
        try{
            tablero.movimiento(x,y,fx,fy);
        }catch(SenkuExcepcion e){
            System.out.println(e.ACCION);
        }
    }

    /**
     * Finaliza el juego
     */
    public void finalizar(){
        System.out.println("Fin del juego");
    }
}