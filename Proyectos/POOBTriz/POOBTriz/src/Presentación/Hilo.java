package Presentación;

import java.util.logging.*;
import Dominio.*;

/**
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-1
 */
public class Hilo extends Thread {

    private Tablero tab;
    private int puntaje;
    private POOBTrizForm pf;

    /**
     *
     * @param tab
     * @param pf
     */
    Hilo(Tablero tab, POOBTrizForm pf){
        this.tab = tab;
        this.pf = pf;
    }

    /**
     * Corre el hilo, para el juego
     */
    @Override
    public void run(){
        while(true){

            tab.nuevoTetromino();

            while (tab.caidaTetromino()){
                try {

                    Thread.sleep(500);
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(tab.bloquePorFuera()){
                System.out.println("Juego terminado");
                break;
            }
            tab.tetrominoAFondo();
            puntaje += tab.quitarLinea();
            pf.actualizarPuntaje(puntaje);
        }
    }
}
