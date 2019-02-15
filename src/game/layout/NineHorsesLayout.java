package game.layout;

import piece.HorseKnight;

import java.awt.Color;

public class NineHorsesLayout extends PieceLayout {

    public NineHorsesLayout() {
        super("Nine Horses",9,9,new HorseKnight(Color.WHITE,0,0),new HorseKnight(Color.WHITE,1,0),
        new HorseKnight(Color.WHITE,2,0),new HorseKnight(Color.WHITE,3,0),new HorseKnight(Color.WHITE,4,0),
        new HorseKnight(Color.WHITE,5,0),new HorseKnight(Color.WHITE,6,0),new HorseKnight(Color.WHITE,7,0),
        new HorseKnight(Color.WHITE,8,0),new HorseKnight(Color.BLACK,0,8),new HorseKnight(Color.BLACK,1,8),
        new HorseKnight(Color.BLACK,2,8),new HorseKnight(Color.BLACK,3,8),new HorseKnight(Color.BLACK,4,8),
        new HorseKnight(Color.BLACK,5,8),new HorseKnight(Color.BLACK,6,8),new HorseKnight(Color.BLACK,7,8),
        new HorseKnight(Color.BLACK,8,8) );
    }

}
