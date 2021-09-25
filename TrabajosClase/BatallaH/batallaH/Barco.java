 

import java.util.ArrayList;

public class Barco extends Maquina{
    private int numero;
    private ArrayList<Marino> marinos;
    
    public Barco(){
        super();
    }
    
    @Override
    public boolean seranDestruidas(int longitud, int latitud){
        return false;
    }
}
