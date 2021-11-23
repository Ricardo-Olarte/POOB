package Presentación;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-1
 */
public class VentanaPrincipal extends JFrame {

    /*Atributos tamaño*/
    private static final Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int ALTO = DIMENSION.height;
    private static final int ANCHO = DIMENSION.width;
    private Container container;
    private Color color;

    /*Menu*/
    private JMenuBar menuBar;
    private JMenu configuracion;
    private JMenuItem colorMenu;

    /**
     * Constructor Ventana Principal
     */
    public VentanaPrincipal(){
        prepareElementos();
    }

    /**
     * Prepara los componentes que se necesitan
     */
    public void prepareElementos(){
        this.setTitle("Senku");
        this.setSize( ANCHO/2,ALTO/2);
        setLocationRelativeTo(null);

        prepareElementosTablero();
        prepareAccionesMenu();
    }

    /**
     * Prepara los elementos del juego
     */
    public void prepareElementosTablero(){
        menuBar = new JMenuBar();

        configuracion = new JMenu("Configuración");

        colorMenu = new JMenuItem("Cambiar color de Tablero");

        configuracion.add(colorMenu);

        menuBar.add(configuracion);
        setJMenuBar(menuBar);

        container = this.getContentPane();
        container.setLayout(new GridLayout());
    }

    /**
     * Prepara las acciones del menu
     */
    public void prepareAccionesMenu() {
        colorMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                color = JColorChooser.showDialog(null, "Seleccione un color", Color.BLACK);
                container.setBackground(color);
            }
        });
    }

    /**
     * Actualiza el juego
     */
    public void refresque(){}
}
