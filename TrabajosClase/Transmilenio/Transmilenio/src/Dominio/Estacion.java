package Dominio;

/**
 * Parada de una troncal
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-2
 */
public class Estacion {

    private String nombre;
    private String nivelOcupacion;
    private String tiempoEspera;

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

}
