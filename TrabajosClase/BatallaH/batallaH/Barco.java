import java.util.ArrayList;

/**
 * Clase Barco, heredada de maquina, contiene marinos
 */
public class Barco extends Maquina{
    private int numero;
    private ArrayList<Marino> marinos;
    
    /**
     * Constructor de Barco
     */
    public Barco(){
        super();
    }
    
    /**
     * @return boolean, si el barco esta dentro del rango de la explosion
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
     * @return boolean, el barco es debil solo si tiene menos de cinco marinos
     */
    @Override
    public boolean esDebil(){
        return marinos.size() <= 5;
    }
}
