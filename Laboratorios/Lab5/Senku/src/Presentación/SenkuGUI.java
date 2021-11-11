package Presentación;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SenkuGUI extends JFrame {

    /*Atributos tamaño*/
    private static final Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int ALTO = DIMENSION.height;
    private static final int ANCHO = DIMENSION.width;

    /*Menu*/
    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenuItem nuevo,abrir,salvar,salir;
    private JFileChooser fileChooser;

    /*Ventana*/
    private JPanel ventanaPrincipal;

    /**
     * Constructor de la clase SenkuGUI
     */
    public SenkuGUI(){
        prepareElementos();
        prepareAcciones();
    }

    /**
     * Prepara los elementos de la ventana
     */
    public void prepareElementos(){
        this.setTitle("Senku");
        this.setSize( ANCHO/2,ALTO/2);
        setLocationRelativeTo(null);

        fileChooser = new JFileChooser();

        ventanaPrincipal = new JPanel();
        ventanaPrincipal.setLayout(new CardLayout(0,0));

        prepareElementosMenu();
        prepareAccionesMenu();
        prepareElementosTablero();
    }

    /**
     * Prepara los componentes del menu
     */
    public void prepareElementosMenu(){
        menuBar = new JMenuBar();

        archivo = new JMenu("Archivo");

        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir");
        salvar = new JMenuItem("Salvar");
        salir = new JMenuItem("Salir");

        archivo.add(nuevo);
        archivo.add(abrir);
        archivo.add(salvar);
        archivo.add(salir);

        menuBar.add(archivo);
        setJMenuBar(menuBar);
    }

    /**
     * Prepara el tablero incial
     */
    public void prepareElementosTablero(){

    }

    /**
     *
     */
    public void refresque(){}

    /**
     * Prepara las acciones
     */
    public void prepareAcciones(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                accionCerrar();
            }
        });
    }

    /**
     * Prepara las acciones del menu
     */
    public void prepareAccionesMenu(){
        abrir.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
                accionAbrir();
            }
        });

        salvar.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
                accionSalvar();
            }
        });

        salir.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
                accionCerrar();
            }
        });
    }

    /**
     * Abre un archivo
     */
    public void accionAbrir(){
        fileChooser.setVisible(true);
        int r = fileChooser.showOpenDialog(abrir);
        if( r == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(abrir,"El archivo de nombre "+archivo.getName()+" que se trata de abrir en la ruta "+archivo+"\n Esta la función se encuentra en construcción.");
        }
        fileChooser.setVisible(false);
    }

    /**
     *
     */
    public void accionSalvar(){
        fileChooser.showSaveDialog(this);
        File file = fileChooser.getSelectedFile();
        JOptionPane.showMessageDialog(salvar,"El archivo de nombre "+archivo.getName()+" que se trata de salvar, no puede hacer modificaciones, esta la función se encuentra en construcción.");
    }

    /**
     * Cierra la ventana
     */
    public void accionCerrar(){
        int r = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir?");
        if(r==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        SenkuGUI ventana = new SenkuGUI();
        ventana.setVisible(true);
    }
}
