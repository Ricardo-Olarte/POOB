package dominio;


/**
 * Es una clase de excepciones ComboOfertasExcepcion.
 * 
 * @author Acosta
 * @author Olarte
 * @version 2021-2
 */
public class ComboOfertasExcepcion extends Exception
{   
    public static final String COMBO_VACIO = "Combo vacio";
    public static final String COMBO_SIN_PRECIOS = "Combo no tiene producto con su respectivo precio";
    public static final String PRODUCTO_ERROR_PRECIO = "Producto no tiene un precio adecuado";
    public static final String PRODUCTO_SIN_PRECIO = "Producto no tiene un precio";
    
    /**
     * @param mensaje, indica el mensaje de la excepcion, para mostrar cuales de los errores se cometió
     */
    public ComboOfertasExcepcion(String mensaje){
        super(mensaje);
    }
}
