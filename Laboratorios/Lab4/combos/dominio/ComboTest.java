package dominio;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ComboTest{
   
    
    public ComboTest(){
    }

    
    @Test
    public void deberiaCalcularElPrecioDeUnCombo(){
        Combo c = new Combo("Rapido", 10);
        c.adProducto(new Producto("Coca Cola", 1000));
        c.adProducto(new Producto("Hamburguesa",8000));
        c.adProducto(new Producto("Papas", 1000));
        try {
           assertEquals(9000,c.precio());
        } catch (ComboOfertasExcepcion e){
            fail("Lanzó excepcion");
        }    
    }    
    
    @Test
    public void deberiaLanzarExcepcionSiElComboNoTieneProductos(){
        Combo c = new Combo("Rapido", 10);
        try { 
           int precio=c.precio();
           fail("No lanzó excepcion");
        } catch (ComboOfertasExcepcion e) {
            assertEquals(ComboOfertasExcepcion.COMBO_VACIO,e.getMessage());
        }    
    }    
    
    
   @Test
    public void deberiaLanzarExcepcionSiUnPrecioNoEsCorrecto(){
        Combo c = new Combo("Rapido", 10);
        c.adProducto(new Producto("Coca Cola", 1000));
        c.adProducto(new Producto("Hamburguesa",8000));
        c.adProducto(new Producto("Papas", -1000));
        try { 
           int precio=c.precio();
           fail("No lanza la excepcion");
        } catch (ComboOfertasExcepcion e) {
            assertEquals(ComboOfertasExcepcion.PRODUCTO_ERROR_PRECIO,e.getMessage());
        }    
    }     
    
   @Test
    public void deberiaLanzarExcepcionSiNoSeConoceUnPrecioDeUnProducto(){
        Combo c = new Combo("Rapido", 10);
        c.adProducto(new Producto("Coca Cola", 1000));
        c.adProducto(new Producto("Hamburguesa",null));
        c.adProducto(new Producto("Papas", -1000));
        try { 
           int precio=c.precio();
           fail("No lanza la excepcion");
        } catch (ComboOfertasExcepcion e) {
            assertEquals(ComboOfertasExcepcion.PRODUCTO_SIN_PRECIO,e.getMessage());
        }    
    }
}
