package tiposTetrominos;

import java.awt.Color;
import poobtriz.Tetromino;

public class TetrominoS extends Tetromino{
    public TetrominoS(){
        super(new int[][]{  {0,1,1},
                            {1,1,0}
        });
    color = Color.green;
    }
}
