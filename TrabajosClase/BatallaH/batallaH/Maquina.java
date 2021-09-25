 

public abstract class Maquina{
    public Ubicacion ubicacion;
    
    /**
     * Constructor de la clase Maquina,
     */
    public Maquina(){
        
    }
    
    /**
     * Mueve la maquina al norte
     */
    public final void alNorte(){
        ubicacion.alNorte();
    }
    
    /**
     * Mueve la maquina a la distancia definida
     * @param int dLon, distancia definida en longitud
     * @param int dLat, distancia definida en latitud
     */
    public final void avance(int dLon, int dLat){
        ubicacion.avance(dLon,dLat);
    }
    
    /**
     * 
     */
    public abstract boolean seranDestruidas(int longitud, int latitud);
}
