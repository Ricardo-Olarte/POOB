package Presentación;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class SenkuGUI extends JFrame {

    private static final Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int ALTO = DIMENSION.height;
    private static final int ANCHO = DIMENSION.width;
    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenuItem nuevo,abrir,salvar,salir;
    private JFileChooser fileChooser;

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

        prepareElementosMenu();
        prepareAccionesMenu();
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
        salir.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
                accionCerrar();
            }
        });

        abrir.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
                accionAbrir();
            }
        });
    }

    /**
     * Abre un archivo
     */
    public void accionAbrir(){
        fileChooser.setVisible(true);
        int r = fileChooser.showOpenDialog(abrir);
        if( r == fileChooser.APPROVE_OPTION ){
            File file = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(abrir,"El archivo de nombre "+archivo.getName()+" que se trata de abrir en la ruta "+archivo+"\n NO se pudo abrir ya que esta la funcion se encuentra en construccion.");
        }

        fileChooser.setVisible(false);
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

    public static void main(String[] args) {
        SenkuGUI ventana = new SenkuGUI();
        ventana.setVisible(true);
    }
}
