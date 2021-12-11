package tiposTetrominos;

import java.awt.Color;
import poobtriz.Tetromino;

public class TetrominoL extends Tetromino{
    public TetrominoL(){
        super(new int[][]{  {1,0},
                            {1,0},
                            {1,1}
        });
        color = Color.orange;
    }
}
