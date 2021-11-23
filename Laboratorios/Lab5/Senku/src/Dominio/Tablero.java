package Dominio;

/**
 * @Autor Acosta
 * @Autor Olarte
 * @Version 2021-1
 */
public class Tablero{

    private int n;
    private int[][] casillas = {
            {-1,-1,0,1,0,-1,-1},
            {-1,-1,1,1,1,-1,-1},
            {0,1,1,1,1,1,0},
            {1,1,1,0,1,1,1},
            {0,1,1,1,1,1,0},
            {-1,-1,1,1,1,-1,-1},
            {-1,-1,0,1,0,-1,-1}
    };

    /**
     * Constructor tablero
     */
    public Tablero(int n){
        this.n = n;
    }

    /**
     * Movimiento
     * @param x
     * @param y
     * @param fx
     * @param fy
     */
    public void movimiento(int x, int y, int fx, int fy)throws SenkuExcepcion{
        int casilla1 = casillas[x][y],casilla2 = casillas[fx][fy];
        if(casillas[x][y]==-1 || casillas[fx][fy]==-1 || casilla1==0 || casilla2==1)throw new SenkuExcepcion(SenkuExcepcion.ACCION);
        if(casilla1==1 && casilla2==0){
            casillas[x][y]=0;
            casillas[fx][fy]=1;
        }
    }
}
