package tiposTetrominos;

import java.awt.Color;
import poobtriz.Tetromino;

public class TetrominoJ extends Tetromino{
    public TetrominoJ(){
        super(new int[][]{  {0,1},
                            {0,1},
                            {1,1}
            
        });
        color = Color.blue;
    }
}
