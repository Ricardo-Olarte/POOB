package dominio;

import javax.swing.*;
import java.util.*;
import java.io.*;

public class Artico implements Serializable{
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

    public Artico() {
        elementos= new ArrayList<EnArtico>();
        poloNorteX = (int)(Math.random() * MAXIMO);
        poloNorteY = (int)(Math.random() * MAXIMO);
        enPoloNorte=false;
    }

    /**
     * Nuevo Archivo
     */
    public void nuevo(){
        nuevoArtico();
    }

    /**
     * Abrir archivo
     * @param file, es el archivo abrir
     */
    public void abra(File file) throws ArticoExcepcion{
        JOptionPane.showMessageDialog(null,ArticoExcepcion.OPCION);
    }

    /**
     * Salvar el actual archivo
     * @param file, archivo a guardar
     */
    public void guarde(File file)throws ArticoExcepcion{
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(polo);
            outputStream.close();
        }catch (Exception e){
            System.out.println(ArticoExcepcion.OPCION);
        }
    }

    /**
     * Importar el archivo
     * @param file, archivo a importar
     */
    public void importe(File file)throws ArticoExcepcion{
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        }catch (Exception e){
            System.out.println(ArticoExcepcion.OPCION);
        }
    }

    /**
     * Exportar el archivo
     * @param file , archivo a exportar
     */
    public void exporte(File file)throws ArticoExcepcion{
        try{

        }catch (Exception e){
            System.out.println(ArticoExcepcion.OPCION);
        }
    }

    /**
     *
     * @return
     */
    public ArrayList getElementos(){
        return elementos;
    }
    
    public void algunosEnArtico(){
        Esquimal esquimal1 = new Esquimal(this, "aaju", 10, 10);
        Esquimal esquimal2 = new Esquimal(this, "alek", 200, 20);
        elementos.add(esquimal1);
        elementos.add(esquimal2);
        EsquimalSordo esquimalSordo1 = new EsquimalSordo(this, "aguu", 50, 50);
        EsquimalSordo esquimalSordo2 = new EsquimalSordo(this, "ivanna", 100, 100);
        elementos.add(esquimalSordo1);
        elementos.add(esquimalSordo2);
        Iglu superiorDerecha = new Iglu(this, MAXIMO, MAXIMO);
        Iglu superiorIzquierda = new Iglu(this, 0, MAXIMO);
        Iglu inferiorDerecha = new Iglu(this, MAXIMO, 0);
        Iglu inferiorIzquierda = new Iglu(this, 0, 0);
        elementos.add(superiorDerecha);
        elementos.add(superiorIzquierda);
        elementos.add(inferiorDerecha);
        elementos.add(inferiorIzquierda);
        EsquimalExplorador esquimalExplorador1 = new EsquimalExplorador(this, "nanuk", 500, 500);
        EsquimalExplorador esquimalExplorador2 = new EsquimalExplorador(this, "sialuk", 250, 250);
        elementos.add(esquimalExplorador1);
        elementos.add(esquimalExplorador2);
        EsquimalAngel esquimalAngel1 = new EsquimalAngel(this, "Juan", 150, 300);
        EsquimalAngel esquimalAngel2 = new EsquimalAngel(this, "Ricardo", 300, 150);
        elementos.add(esquimalAngel1);
        elementos.add(esquimalAngel2);
        Pozo pozo1 = new Pozo(this, 150, 150);
        elementos.add(pozo1);
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
        ArrayList<Esquimal> elementosaBorrar = new ArrayList<Esquimal>();
        for(EnArtico e:elementos){
            if(e instanceof Pozo){
                elementosaBorrar = ((Pozo) e).caida();
            }
            e.accion();
        }
        elementos.removeAll(elementosaBorrar);
    }

    public void improvisen(){
        for(EnArtico e:elementos){
            e.improvise();
        }
    }

    public void corten(){
        for(EnArtico e:elementos){    
            e.corte();
        }
    }
}  

