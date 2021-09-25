 

public class Avion extends Maquina{
    private String placa;
    private boolean enAire;
    private Marino piloto;
    private Marino copiloto;
    
    public Avion(){
        super();
    }
    
    /**
     * @return
     * @param
     * @param
     */
    @Override
    public boolean seranDestruidas(int longitud, int latitud){
        Ubicacion ubicacionAfectada = new Ubicacion(longitud,latitud);
        if(ubicacion.equals(ubicacionAfectada) && !enAire){
            return true;
        }
        return false;
    }
}
