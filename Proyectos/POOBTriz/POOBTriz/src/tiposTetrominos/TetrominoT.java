package tiposTetrominos;

import java.awt.Color;
import poobtriz.Tetromino;

public class TetrominoT extends Tetromino{
    public TetrominoT(){
        super(new int[][]{  {1,1,1},
                            {0,1,0}
        });
        color = Color.magenta;
    }
}
