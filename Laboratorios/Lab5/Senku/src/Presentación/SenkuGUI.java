package Presentación;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Dominio.Senku;

/**
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-1
 */
public class SenkuGUI extends JFrame{

    /*Atributos tamaño*/
    private static final Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int ALTO = DIMENSION.height;
    private static final int ANCHO = DIMENSION.width;

    /*Menu*/
    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenu configuracion;
    private JMenuItem nuevo,abrir,salvar,salir, size;
    private JFileChooser fileChooser;
    private JButton cambiarColor, start, restart;
    private Color color;
    private JPanel panel1, panel2, panel3, panel4, panel5, contenedorC;
    private JComboBox opcionesTamano;
    private JPanel contenerdorJ,panelJ,panelB;
    private char[][] inicio = {
            {'0','0','E','F','E','0','0'},
            {'0','0','F','F','F','0','0'},
            {'E','F','F','F','F','F','E'},
            {'F','F','F','E','F','F','F'},
            {'E','F','F','F','F','F','E'},
            {'0','0','F','F','F','0','0'},
            {'0','0','E','F','E','0','0'}
    };

    /*Ventana*/
    private VentanaPrincipal ventanaPrincipal;
    private int moves, caps;

    /*Juego*/
    private Senku juego;

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

        ventanaPrincipal = new VentanaPrincipal();

        prepareElementosMenu();
        prepareAccionesMenu();
        prepareElementosTablero();
    }

    /**
     * Prepara los componentes del tablero
     */
    public void prepareElementosTablero(){
        cambiarColor = new JButton("Cambiar color");
        start = new JButton("Iniciar");
        restart = new JButton("Reiniciar");
        setLayout(new BorderLayout());
        panel1 = new JPanel();
        add(panel1, BorderLayout.SOUTH);
        panel2 = new JPanel();
        add(panel2, BorderLayout.NORTH);
        JLabel title = new JLabel("Senku");
        title.setFont(new Font("Verdana",1,20));
        panel2.add(title);
        //movientos
        JLabel movi = new JLabel("Movimientos:", moves);
        JLabel cap = new JLabel("Capturas:", caps);
        cap.setFont(new Font("Verdana",1,12));
        movi.setFont(new Font("Verdana",1,12));
        //capturados
        title.setForeground(Color.white);
        panel2.setBackground(Color.black);
        panel2.setPreferredSize(new Dimension(50, 50));
        panel3 = new JPanel();
        add(panel3, BorderLayout.EAST);
        panel3.setBackground(Color.black);
        panel3.setPreferredSize(new Dimension(50, 50));
        panel4 = new JPanel();
        add(panel4, BorderLayout.WEST);
        panel4.setBackground(Color.black);
        panel4.setPreferredSize(new Dimension(50, 50));
        panel5 = new JPanel();
        panel5.setBackground(Color.white);
        add(panel5, BorderLayout.CENTER);
        //Panel juego
        contenerdorJ = new JPanel();
        //Crea el tablero
        contenerdorJ.setLayout(new BorderLayout());
        panelJ = new JPanel();
        panelJ.setLayout(new GridLayout(inicio.length, inicio[0].length,10,10));
        for(int i = 0; i < inicio.length; i++){
            for(int j = 0; j < inicio[i].length ; j++){
                if(inicio[i][j] == '0'){
                    panelJ.add(new JButton(""));
                }else if(inicio[i][j] == 'E'){
                    panelJ.add(new JButton("-"));
                } else if(inicio[i][j] == 'F'){
                    panelJ.add(new JButton("o"));
                }
            }
        }
        contenerdorJ.add(panelJ,BorderLayout.CENTER);
        add(contenerdorJ,BorderLayout.CENTER);
        contenedorC = new JPanel();
        contenedorC.setLayout(new GridLayout(3, 1, 50, 50));
        opcionesTamano = new JComboBox();
        opcionesTamano.addItem("9x9");
        opcionesTamano.addItem("11x11");
        opcionesTamano.addItem("13x13");
        panel1.add(movi);
        JTextField moviCaja = new JTextField("0");
        moviCaja.setEditable(false);
        panel1.add(moviCaja);
        panel1.add(cambiarColor);
        panel1.add(start);
        panel1.add(restart);
        panel1.add(opcionesTamano, BorderLayout.SOUTH);
        panel1.add(cap);
        JTextField capCaja = new JTextField("0");
        capCaja.setEditable(false);
        panel1.add(capCaja);
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
        configuracion = new JMenu("Configuración");
        size = new JMenuItem("Tamaño");
        configuracion.add(size);
        menuBar.add(configuracion);
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
        cambiarColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(null, "Seleccione un Color", Color.black);
                panelJ.setBackground(color);
            }
        });
    }

    /**
     * Prepara las acciones del menu
     */
    public void prepareAccionesMenu(){
        nuevo.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
                accionNuevo();
            }
        });

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

        size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { cambiarTamano(); }
        });
    }

    /**
     * Abre un nuevo
     */
    public void accionNuevo(){
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
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
     * Guarda un archivo
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
     *
     */
    public void cambiarTamano(){
        int alto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva altura de la ventana"));
        int ancho = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ancho de la ventana"));
        setSize(new Dimension(alto, ancho));
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
