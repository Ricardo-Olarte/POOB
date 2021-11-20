package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Sistema de transmilenio
 * Opera con troncales y estaciones
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-2
 */
public class Sistema{

    private LinkedList<Estacion> estaciones;
    private ArrayList<Ruta> rutas;
    private HashMap<String[],Integer> rutasT;

    /**
     * Constructor del sistema de transmilenio
     */
    public Sistema(){
        estaciones = new LinkedList<Estacion>();
        rutas = new ArrayList<Ruta>();
        rutasT = new HashMap<String[],Integer>();
    }

    /**
     * Se conoce el tiempo de espera de una estacion dado su nombre
     * @param nombre
     * @return
     * @throws SistemaExcepcion
     */
    public int tiempoEsperaEstacion(String nombre)throws SistemaExcepcion{
        for(int i=0;i<estaciones.size();i++){
            if(estaciones.get(i).getNombre()==nombre){
                return estaciones.get(i).getTiempoEspera();
            }
        }
        if(nombre==null)throw new SistemaExcepcion(SistemaExcepcion.NOMBRE_ESTACION);
        return -1;
    }

    /**
     * @param nombreRuta
     * @param estacion1
     * @param estacion2
     * @return
     */
    public int paradas(String nombreRuta, String estacion1, String estacion2){
        String[] temp = {nombreRuta,estacion1,estacion2};
        if(rutasT.containsKey(temp)){
            return rutasT.get(temp);
        }
        for(Ruta r:rutas){
            if(r.getNombre()==nombreRuta){
                int numeroParadas = r.completarRuta(estacion1,estacion2);
                rutasT.put(temp,numeroParadas);
            }
        }
        return rutasT.get(temp);
    }
}
