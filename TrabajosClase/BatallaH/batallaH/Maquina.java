/**
 * Clase maquina, se describe como una elemento de ataque o defensa
 */
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
     * consulta si la maquina pude afectarse por una explosion dada en la coordenada
     * @param int longitud
     * @param int latitud
     */
    public abstract boolean seranDestruidas(int longitud, int latitud);
    
    /**
     * consulta si la maquina es debil
     */
    public abstract boolean esDebil();
}
