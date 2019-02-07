package game;

import piece.Pawn;

public class StandardLayout extends PieceLayout {

    public StandardLayout(Game g) {
        super(8, 8, g, new Pawn(0,1), new Pawn(1,1), new Pawn(2,1), new Pawn(3,1),
        new Pawn(4,1), new Pawn(5,1), new Pawn(6,1), new Pawn(7,1));
    }

}
