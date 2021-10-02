/**
 * Indica un lugar del tablero para la maquina
 */
public class Ubicacion {
    private int longitud;
    private int latitud;
    
    /**
     * Constructor de la Clase Ubicacion
     */
    public Ubicacion(int longitud, int latitud){
        this.longitud = longitud;
        this.latitud = latitud;
    }
    
    /**
     * Cambia la longitud y latitud, en sentido norte
     */
    public void alNorte(){
        longitud += 1;
        latitud += 1;
    }
    
    /**
     * mueve la longitud y latitud a una distancia definida
     * @param int dLon, distancia definida en longitud
     * @param int dLat, distancia definida en latitud
     */
    public void avance(int dLon, int dLat){
        longitud += dLon;
        latitud += dLat;
    }
}
