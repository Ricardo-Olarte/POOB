 

import java.util.ArrayList;

public class Flota {
    private Tablero tablero;
    private String nombre;
    private ArrayList<Marino> marinos;
    private ArrayList<Maquina> maquinas;
    
    /**
     * Constructor de la clase Flota, quien tiene varias maquinas
     */
    public Flota(){
    
    }
    
    /**
     *  Mueve la flota a una posicion al norte
     */
    public void alNorte(){
        for(Maquina m: maquinas){
            m.alNorte();
        }
    }
}
