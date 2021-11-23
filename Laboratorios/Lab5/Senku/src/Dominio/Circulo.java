package Dominio;

/**
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-1
 */
public class Circulo {

    private int diametro;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Constructor de circulo
     */
    public Circulo(String color){
        diametro = 50;
        xPosition = 50;
        yPosition = 50;
        this.color = color;
        isVisible = false;
    }

    /**
     * Hacer este circulo Visible
     */
    public void hacerVisible()
    {
        isVisible = true;
        dibujar();
    }

    /**
     * Hacer este circulo invisible
     */
    public void hacerInvisible()
    {
        borrar();
        isVisible = false;
    }

    /**
     * Cambia de color
     */
    public void cambiarColor(String nuevoColor) {
        color = nuevoColor;
        dibujar();
    }

    /**
     * Dibujar
     */
    private void dibujar() {
    }

    /**
     * borrar
     */
    private void borrar(){
    }
}
