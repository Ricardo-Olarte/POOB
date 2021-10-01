package dominio;
import java.util.*;

public class Artico{
    public static final int MAXIMO = 500;
    private static Artico polo = null;

    public static Artico demeArtico() {
        if (polo==null){
            polo=new Artico();
        }
        return polo;
    }

    private static void nuevoArtico() {
        polo=new Artico();
    }   

    public static void cambieArtico(Artico d) {
        polo=d;
    }       

    private ArrayList<EnArtico> elementos;
    private int poloNorteX;
    private int poloNorteY;
    private boolean enPoloNorte;
 
    private Artico() {
        elementos= new ArrayList<EnArtico>();
        poloNorteX = (int)(Math.random() * MAXIMO);
        poloNorteY = (int)(Math.random() * MAXIMO);
        enPoloNorte=false;
    }

    public void algunosEnArtico(){    
    }  

    public EnArtico demeEnArtico(int n){
        EnArtico h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }

    
    public void adicione(EnArtico e){
        elementos.add(e);
    }

    public int numeroEnArtico(){
        return elementos.size();
    }

    public boolean enPoloNorte(EnArtico e){
        boolean ok=(poloNorteX==e.getPosicionX() && poloNorteY==e.getPosicionY());
        enPoloNorte = enPoloNorte || ok;
        return enPoloNorte;
    }     
    
    public void accion(){
    }

    public void improvisen(){
    }    

    public void corten(){
    }  
}
