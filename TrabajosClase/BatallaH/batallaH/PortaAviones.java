import java.util.*;

/**
 * Clase PortaAvion, poirta aviones y heredada de Barco
 */
public class PortaAviones extends Barco{
    private int capacidad;
    private ArrayList<Avion> aviones;
    
    /**
     * Constructor de PortaAviones
     */
    public PortaAviones(){
        super();
    }
    
    /**
     * @return boolean si el portaAvion se ve afectado por la explosion
     * @param int longitud
     * @param int latitud
     */
    @Override
    public boolean seranDestruidas(int longitud, int latitud){
        Ubicacion ubicacionAfectada = new Ubicacion(longitud,latitud);
        if(ubicacion.equals(ubicacionAfectada)){
            return true;
        }
        return false;
    }
    
    /**
     * @return boolean, si el PortaAvion es debil, solo si el barco es debil o un avion en aire es debil
     */
    public boolean esDebil(){
        if(super.esDebil()){
            return true;
        }
        for(Avion a:aviones){
            if(a.enAire() && a.esDebil()){
                return true;
            }
        }
        return false;
    }
}
