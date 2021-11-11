package Dominio;

public class SenkuExcepcion extends Exception{

    private static final String FUNCION = "Esta función sigue en construcción";
    /**
     * Constructor SenkuExcepcion
     * @param message, mensaje que se mostrara por pantalla
     */
    public SenkuExcepcion(String message){
        super(message);
    }
}
