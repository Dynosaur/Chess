package piece;

public final class HorseKnight extends Piece {
 void onMove() {} boolean pieceMoveSet(int xChg, int yChg) {
        return ( (Math.abs(xChg) == 2 && Math.abs(yChg) == 1) || (Math.abs(xChg) == 1 && Math.abs(yChg) == 2) );
    }

    public HorseKnight(int x, int y, java.awt.Color c) {
        super(x, y, c);
    }

    public HorseKnight(board.Board b, game.Player p, int x, int y) {
        super(b,p,x,y);
    }

}
