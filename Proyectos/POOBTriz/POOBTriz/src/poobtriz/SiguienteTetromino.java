package poobtriz;

import poobtriz.Tetromino;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SiguienteTetromino extends JPanel {

    private Tetromino siguiente;
    private final int tamCelda = 25;
    private int tipo;

    public SiguienteTetromino(int tipo){
        this.tipo = tipo;
        setPreferredSize(new Dimension(100, 200));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Siguiente", TitledBorder.CENTER, TitledBorder.TOP, new Font("Century Gothic", Font.BOLD, 20),  Color.black));
    }

    public void dibujarBloque(Graphics g){
        int[][] forma = siguiente.getTipo();
        int height = forma.length;
        int width = forma[0].length;
        Color c = siguiente.getColor();
        int x;
        int y;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(forma[i][j] == 1){
                    if(tipo == 1){
                        if (siguiente.getClass().getName().contains("BloqueL")){
                            x = (4 + j) * tamCelda;
                            y = (i + 3) * tamCelda;
                        }else if(siguiente.getClass().getName().contains("BloqueI")){
                            x = (4 + j) * tamCelda;
                            y = (i + 2) * tamCelda;
                        }else if(siguiente.getClass().getName().contains("BloqueC")){
                            x = (3 + j) * tamCelda;
                            y = (i + 3) * tamCelda;
                        }else if(siguiente.getClass().getName().contains("BloqueT")){
                            x = (3 + j) * tamCelda;
                            y = (i + 3) * tamCelda;
                        }else{
                            x = (3 + j) * tamCelda;
                            y = (i + 3) * tamCelda;
                        }
                    }else{
                        if (siguiente.getClass().getName().contains("BloqueL")){
                            x = (siguiente.getX() + j) * tamCelda;
                            y = (i + 2) * tamCelda;
                        }else if(siguiente.getClass().getName().contains("BloqueI")){
                            x = (4 + j) * tamCelda;
                            y = (i + 2) * tamCelda;
                        }else if(siguiente.getClass().getName().contains("BloqueC")){
                            x = (4 + j) * tamCelda;
                            y = (i + 3) * tamCelda;
                        }else if(siguiente.getClass().getName().contains("BloqueT")){
                            x = (4 + j) * tamCelda;
                            y = (i + 3) * tamCelda;
                        }else{
                            x = (3 + j) * tamCelda;
                            y = (i + 3) * tamCelda;
                        }
                    }
                    dibujarCuadro(g, c, x, y);
                }
            }
        }
    }

    public void dibujarCuadro(Graphics g, Color c, int x, int y){
        g.setColor(c);
        g.fillRect(x, y, tamCelda, tamCelda);
        g.setColor(new Color(0, 0, 0));
        g.drawRect(x, y, tamCelda, tamCelda);
    }

    public void setBloque(Tetromino b){
        siguiente = b;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        dibujarBloque(g);
    }
}