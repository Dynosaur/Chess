package game;

import piece.Bishop;
import piece.HorseKnight;
import piece.King;
import piece.Pawn;
import piece.Queen;
import piece.Rook;

import java.awt.Color;

public class StandardLayout extends PieceLayout {

    public StandardLayout() {
        super("Standard",8,8,new Pawn(Color.WHITE,0,1),new Pawn(Color.WHITE,1,1),
        new Pawn(Color.WHITE,2,1),new Pawn(Color.WHITE,3,1),new Pawn(Color.WHITE, 4,1),
        new Pawn(Color.WHITE,5,1),new Pawn(Color.WHITE,6,1),new Pawn(Color.WHITE,7,1),
        new Rook(Color.WHITE,0, 0),new HorseKnight(Color.WHITE,1,0),new Bishop(Color.WHITE,2,0),
        new Queen(Color.WHITE,3,0),new King(Color.WHITE,4,0),new Bishop(Color.WHITE,5,0),
        new HorseKnight(Color.WHITE,6,0),new Rook(Color.WHITE,7,0),new Pawn(Color.BLACK,7,6),
        new Pawn(Color.BLACK,6,6),new Pawn(Color.BLACK,5,6),new Pawn(Color.BLACK,4,6),
        new Pawn(Color.BLACK, 3,6),new Pawn(Color.BLACK,2,6),new Pawn(Color.BLACK,1,6),
        new Pawn(Color.BLACK,0,6),new Rook(Color.BLACK,7, 7),new HorseKnight(Color.BLACK,6,7),
        new Bishop(Color.BLACK,5,7),new Queen(Color.BLACK,4,7),new King(Color.BLACK,3,7),
        new Bishop(Color.BLACK,2,7),new HorseKnight(Color.BLACK,1,7),new Rook(Color.BLACK,0,7));
    }

}
