import java.util.*;

/**
 * Clase avion, herencia de maquina, quien ataca en aire, dirigida por piloto o copiloto
 */
public class Avion extends Maquina{
    private String placa;
    private boolean enAire;
    private Marino piloto;
    private Marino copiloto;
    
    /**
     * Constructor de Avion
     */
    public Avion(){
        super();
    }
    
    /**
     * @return boolean, si el avion es afectado por la explosion, no le afecta si esta en aire
     * @param int longitud
     * @param int latitud
     */
    @Override
    public boolean seranDestruidas(int longitud, int latitud){
        Ubicacion ubicacionAfectada = new Ubicacion(longitud,latitud);
        if(ubicacion.equals(ubicacionAfectada) && !enAire){
            return true;
        }
        return false;
    }
    
    /**
     * @return boolean, indicando si el avion es debil, solo si no tiene piloto
     */
    @Override
    public boolean esDebil(){
        return Objects.isNull(piloto);
    }
    
    /**
     * @return boolean, si el avion se encuentra en aire
     */
    public boolean enAire(){
        return enAire;
    }
}
