package Dominio;

/**
 * Parada de una troncal
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-2
 */
public class Estacion {

    private String nombre;

    /**
     * Constructor de Estacion
     * @param nombre
     */
    public Estacion(String nombre){
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getNombre(){
        return nombre;
    }

    /**
     *
     * @return
     */
    public int getTiempoEspera(){
        return -1;
    }
}
