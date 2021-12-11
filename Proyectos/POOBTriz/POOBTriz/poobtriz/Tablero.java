package poobtriz;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import tiposTetrominos.*;

public class Tablero extends JPanel {
    private int filasCelda;
    private int columnasCelda;
    private int tamanoCelda;
    private Tetromino tetromino;
    private Color[][] fondo;
    private Tetromino[] tetrominos;
  
    
    public Tablero(JPanel areaJuego, int columnas){
        //areaJuego.setVisible(false);
        this.setBounds(areaJuego.getBounds());
        this.setBackground(areaJuego.getBackground());
        this.setBorder(areaJuego.getBorder());
        columnasCelda = columnas;
        tamanoCelda = this.getBounds().width / columnasCelda;
        filasCelda = this.getBounds().height / tamanoCelda;
        tetrominos = new Tetromino[]{new TetrominoI(), new TetrominoJ(),
                                     new TetrominoL(), new TetrominoO(),
                                     new TetrominoS(), new TetrominoT(),
                                     new TetrominoZ()};
    }
    
    public void limpiarFondo(){
        fondo = new Color[filasCelda][columnasCelda];
    }
    
    public void nuevoTetromino(){
        Random r = new Random(); 
        tetromino = tetrominos[r.nextInt(tetrominos.length)];
        tetromino.generarTetromino(columnasCelda);
    }
    
    public boolean bloquePorFuera(){
        if(tetromino.getY() < 0){
            tetromino = null;
            return true;
        }
        return false;
        
    }
    
    public boolean caidaTetromino(){
        if(puedeBajar() == false){
            
            return false;
        }
        tetromino.moverAbajo();
        repaint();
        return true;
    }
    
    public void moverDerecha(){
        if(tetromino == null) return;
        if(puedeDer() == false) return;
        tetromino.moverDerecha();
        repaint();
    }
    
    public void moverIzquierda(){
        if(tetromino == null) return;
        if(puedeIzq() == false) return;
        tetromino.moverIzquierda();
        repaint();
    }
    
    public void soltarTetromino(){
        if(tetromino == null) return;
        while(puedeBajar()){
            tetromino.moverAbajo();
        }
        repaint();
    }
    
    public void rotarTetromino(){
        if(tetromino == null) return;
        tetromino.rotar();
        if(tetromino.getIzq() < 0 ) tetromino.setX(0);
        if(tetromino.getDer() >= columnasCelda) tetromino.setX(columnasCelda - tetromino.getAncho());
        if(tetromino.getFondo() >= filasCelda) tetromino.setY(filasCelda - tetromino.getAltura());
        
        repaint();
    }
    
    
    private boolean puedeBajar(){
        if(tetromino.getFondo() == filasCelda ){
            return false;
        }
        
        int[][]tipo = tetromino.getTipo();
        int altura = tetromino.getAltura();
        int ancho = tetromino.getAncho();
        
        for(int col = 0; col < ancho; col++){
            for(int fila = altura - 1; fila >= 0; fila--){
                if(tipo[fila][col] != 0){
                    int x = col + tetromino.getX();
                    int y = fila + tetromino.getY() + 1;
                    if(y < 0) break;
                    if(fondo[y][x] != null) return false;
                    break;
                }
            }
        }
        
        return true;
    }
    
    private boolean puedeIzq(){
        if(tetromino.getIzq() == 0) return false;
        
        int[][]tipo = tetromino.getTipo();
        int altura = tetromino.getAltura();
        int ancho = tetromino.getAncho();
        
        for(int fila = 0; fila < altura; fila++){
            for(int col = 0; col < ancho; col++){
                if(tipo[fila][col] != 0){
                    int x = col + tetromino.getX() - 1;
                    int y = fila + tetromino.getY();
                    if(y < 0) break;
                    if(fondo[y][x] != null) return false;
                    break;
                }
            }
        }
        
        return true;
    }
    
    private boolean puedeDer(){
        if(tetromino.getDer() == columnasCelda) return false;
        
        int[][]tipo = tetromino.getTipo();
        int altura = tetromino.getAltura();
        int ancho = tetromino.getAncho();
        
        for(int fila = 0; fila < altura; fila++){
            for(int col = ancho - 1; col >= 0; col--){
                if(tipo[fila][col] != 0){
                    int x = col + tetromino.getX() + 1;
                    int y = fila + tetromino.getY();
                    if(y < 0) break;
                    if(fondo[y][x] != null) return false;
                    break;
                }
            }
        }
        
        return true;
    }
    
    public int quitarLinea(){
        boolean lineaCompleta;
        int lineasBorradas = 0;
        for(int f = filasCelda - 1; f >= 0; f--){
            lineaCompleta = true;
            for(int c = 0; c < columnasCelda; c++){
                if(fondo[f][c] == null){
                    lineaCompleta = false;
                    break;
                }
            }
            if(lineaCompleta){
                lineasBorradas++;
                borrarLinea(f);
                moverTodoAbajo(f);
                borrarLinea(0);
                f++;
                repaint();
            }
        }
        return lineasBorradas;
    }
    
    private void borrarLinea(int f){
        for(int i = 0; i < columnasCelda; i++){
            fondo[f][i] = null;
        }
    }
    
    private void moverTodoAbajo(int f){
        for(int fila = f; fila > 0; fila--){
           for(int col = 0; col < columnasCelda; col++){
               fondo[fila][col] = fondo[fila - 1][col];
           } 
        }
    }
    
    public void tetrominoAFondo(){
        int[][] tipo = tetromino.getTipo();
        int altura = tetromino.getAltura();
        int ancho = tetromino.getAncho();
        int x = tetromino.getX();
        int y = tetromino.getY();
        Color color = tetromino.getColor();
        for(int r = 0; r < altura; r++){
            for(int c = 0; c < ancho; c++){
                if(tipo[r][c] == 1){
                    fondo[r + y][c + x] = color;
                }
            }
        }
    }
    
    private void dibujarTetromino(Graphics g){
        int altura = tetromino.getAltura();
        int ancho = tetromino.getAncho();
        Color color = tetromino.getColor();
        int[][] tipo = tetromino.getTipo();
        
        for (int fila = 0; fila < altura; fila++){
            for(int columna = 0; columna < ancho; columna++){
                if(tipo[fila][columna] == 1){
                    int x = (tetromino.getX() + columna) * tamanoCelda;
                    int y = (tetromino.getY() + fila) * tamanoCelda;
                    dibujarCuadrado(g, color, x, y);
                }
            }
        }
    }
    
    private void dibujarFondo(Graphics g){
        Color color;
        for(int r = 0; r < filasCelda; r++){
            for(int c = 0; c < columnasCelda; c++){
                color = fondo[r][c];
                if(color != null){
                    int x = c * tamanoCelda;
                    int y = r * tamanoCelda;
                    dibujarCuadrado(g, color, x, y);
                }
            }
        }
    }
    
    private void dibujarCuadrado(Graphics g, Color color, int x, int y){
        g.setColor(color);
                    g.fillRect(x, y, tamanoCelda, tamanoCelda);
                    g.setColor(Color.black);
                    g.drawRect(x, y, tamanoCelda, tamanoCelda);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        dibujarFondo(g);
        dibujarTetromino(g);
    }
}
