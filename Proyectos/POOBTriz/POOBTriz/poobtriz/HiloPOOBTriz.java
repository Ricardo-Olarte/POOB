package poobtriz;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloPOOBTriz extends Thread {

    private Tablero tab;
    private int puntaje;
    private POOBTrizForm pf;

    HiloPOOBTriz(Tablero tab, POOBTrizForm pf){
        this.tab = tab;
        this.pf = pf; 
        pf.actualizarPuntaje(puntaje);
        
    }
    
    @Override
    public void run(){  
        while(true){
            
            tab.nuevoTetromino();
            
            while (tab.caidaTetromino()){
                try {

                    Thread.sleep(500);
                } 
                catch (InterruptedException ex) {
                    return;
                }
            }
            if(tab.bloquePorFuera()){
                POOBTriz.juegoTerminado(puntaje);
                break;
            }
            tab.tetrominoAFondo();
            puntaje += tab.quitarLinea();
            pf.actualizarPuntaje(puntaje);
        }
    }
}