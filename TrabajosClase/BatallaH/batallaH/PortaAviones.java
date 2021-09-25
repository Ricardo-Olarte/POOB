import java.util.ArrayList;
public class PortaAviones extends Barco{
    private int capacidad;
    private ArrayList<Avion> aviones;
    
    public PortaAviones(){
        super();
    }
    
    @Override
    public boolean seranDestruidas(int longitud, int latitud){
        return false;
    }
}
