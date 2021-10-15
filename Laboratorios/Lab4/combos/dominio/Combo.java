package dominio; 
 
import java.util.ArrayList;

public class Combo{
    public final static int PRECIO_BASE=10000;
   
    private String nombre;
    private int descuento;
    private ArrayList<Producto> productos;
    
    /**
     * Crea un nuevo combo
     * @param nombre 
     * @param descuento
     */
    public Combo(String nombre, int descuento){
        this.nombre=nombre;
        this.descuento=descuento;
        productos= new ArrayList<Producto>();
    }

    public String nombre(){
        return nombre;
    }

    public void adProducto(Producto p){
        productos.add(p);
    }
    
    
    /**
     * Se calcula el precio del combo actual, la suma de cada producto
     * @return precio, retorna el valor que tiene el combo
     * @throws ComboOfertasExcepcion COMBO_VACIO, si no tiene productos
     * @throws ComboOfertasExcepcion PRODUCTO_SIN_PRECIO, propaga la excepcion
     * @throws ComboOfertasExcepcion PRODUCTO_ERROR_PRECIO, propaga la excepcion
     */
    public int precio() throws ComboOfertasExcepcion{
        int combo = 0;
        if(productos.size() == 0) throw new ComboOfertasExcepcion(ComboOfertasExcepcion.COMBO_VACIO);
        for(Producto p: productos){
            combo += p.precio();
        }
        return combo - (combo * descuento / 100);
    }
    
    /**
     * Calcula el precio por omision de un combo.
     * Para los productos cuyo valor se desconoce se asume el PRECIO_BASE
     * @return 
     * @throws ComboOfertasExcepcion COMBO_VACIO, si no tiene productos
     */
    public int precioOmision() throws ComboOfertasExcepcion{
        int combo = 0;
        if(productos.size() == 0) throw new ComboOfertasExcepcion(ComboOfertasExcepcion.COMBO_VACIO);
        for(Producto p: productos){
            try{
                combo += p.precio();
            }catch(ComboOfertasExcepcion e){
                System.out.println(e.PRODUCTO_SIN_PRECIO);
                System.out.println(e.PRODUCTO_ERROR_PRECIO);
            }
        }
        return combo - (combo * descuento / 100);
    }   
    
    /**
     * Calcula el precio estimado
     * Se asume que el precio de los productos con precio desconocido es el precio mayor de los conocidos
     * Se asume que el precio de los productos con un precio erroneo es el precio menor de los conocidos
     * @return el precio estimado de un combo
     * @throws ComboOfertasExcepcion COMBO_VACIO si no hay productos o COMBO_SIN_PRECIOS no se conocen los precios de ninguno
     */
    public int precioEstimado() throws ComboOfertasExcepcion{
        int combo = 0;
        int menor = (int) Double.POSITIVE_INFINITY, mayor = 0;
        if(productos.size() == 0) throw new ComboOfertasExcepcion(ComboOfertasExcepcion.COMBO_VACIO);
        for(Producto p: productos){
            try{
                combo += p.precio();
                mayor = (p.precio() > mayor)?p.precio():mayor;
                menor = (p.precio() > mayor)?p.precio():menor;
            }catch(ComboOfertasExcepcion e){
                adProducto(new Producto(p.nombre(), mayor));
                adProducto(new Producto(p.nombre(), menor));
            }
        }
        return combo;
    }   
    
    
    /**
     * Calcula el precio de la oferta
     * El precio de oferta es el total, si se conoce. O el mayor entre el asumido y el estimado, si se conocen los dos. 
     * Se asume que el precio de los productos con un precio erroneo es el precio menor de los conocidos
     * @return el precio de la oferta de un combo
     * @throws ComboOfertasExcepcion COMBO_VACIO si no tiene productos y COMBO_NO_VIGENTE si no tiene precio de oferta
     */    
    public int precioOferta() throws ComboOfertasExcepcion{
        return precio();
    } 
    
    public String oferta() throws ComboOfertasExcepcion{
        StringBuffer oferta=new StringBuffer();
        oferta.append(nombre+" : "+ precioOferta());
        oferta.append('\n');
        for(Producto p: productos) {
            oferta.append("\t"+p.nombre()+ " : \t" + p.precio());
            oferta.append('\n');
        }
        return oferta.toString();
    }
}
