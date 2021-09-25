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
    
    /**
     * Mueve las maquinas la distancia definida
     * @param int dLon, distancia definida en longitud
     * @param int dLat, distancia definida en latitud
     */
    public void avance(int dLon, int dLat){
        for(Maquina m: maquinas){
            m.avance(dLon,dLat);
        }
    }
    
    /**
     * @return
     * @param
     * @param
     */
    public ArrayList<Maquina> seranDestruidas(int longitud, int latitud){
        ArrayList<Maquina> seranDestruidas = new ArrayList<Maquina>();
        for(Maquina m: maquinas){
            if(m.seranDestruidas(longitud,latitud)){
                seranDestruidas.add(m);
            }
        }
        return seranDestruidas;
    }
}
