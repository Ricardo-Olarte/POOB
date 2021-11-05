package Presentación;

import javax.swing.*;
import java.awt.*;

public class SenkuGUI extends JFrame {

    private static final Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int ALTO = DIMENSION.height;
    private static final int ANCHO = DIMENSION.width;

    /**
     *
     */
    public void prepareElemntos(){
        this.setTitle("Senku");
        this.setSize( ANCHO/2,ALTO/2);
    }

    /**
     *
     */
    public void prepareAcciones(){

    }
}
