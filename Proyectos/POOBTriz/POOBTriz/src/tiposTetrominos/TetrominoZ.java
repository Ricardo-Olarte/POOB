package tiposTetrominos;

import java.awt.Color;
import poobtriz.Tetromino;

public class TetrominoZ extends Tetromino{
    public TetrominoZ(){
        super(new int[][]{  {1,1,0},
                            {0,1,1}
        });
        color = Color.red;
    }
}
