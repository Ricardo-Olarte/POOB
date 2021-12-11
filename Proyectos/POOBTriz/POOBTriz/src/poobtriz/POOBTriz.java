
package poobtriz;

import javax.swing.JOptionPane;

public class POOBTriz {
    private static POOBTrizForm pf;
    private static InicioForm iff;
    private static PuntuacionesForm puf;

    public static void inicio(){
        pf.setVisible(true);
        pf.iniciarPartida();
    }
    
    public static void mostrarPuntuaciones(){
        puf.setVisible(true);
    }
    
    public static void menu(){
        iff.setVisible(true);
    }
    
    public static void juegoTerminado(int puntaje){
        String nombre = JOptionPane.showInputDialog("Inserte su nombre.");
        pf.setVisible(false);
        puf.addJugador(nombre, puntaje);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pf = new POOBTrizForm();
                iff = new InicioForm();
                puf = new PuntuacionesForm();
                iff.setVisible(true);
            }
        });
    }
    
}
