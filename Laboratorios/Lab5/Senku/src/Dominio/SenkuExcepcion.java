package Dominio;

/**
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-1
 */
public class SenkuExcepcion extends Exception{

    public static final String FUNCION = "Esta función sigue en construcción";
    public static final String ACCION = "No se puede realizar la siguiente acción";

    /**
     * Constructor SenkuExcepcion
     * @param message, mensaje que se mostrara por pantalla
     */
    public SenkuExcepcion(String message){
        super(message);
    }
}
