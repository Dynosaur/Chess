package piece;

/**
 * 1/27/2019
 * @author Alejandro Doberenz
 * @version 0.9.0
 */
public final class King extends Piece {
 void onMove() {
    }
 boolean pieceMoveSet(int xChg, int yChg) {
        return !(xChg < -1 || xChg > 1 || yChg < -1 || yChg > 1);
    }

    public King(int x, int y, java.awt.Color c) {
        super(x, y, c);
    }

    public King(board.Board b, game.Player p, int x, int y) {
        super(b,p,x,y);
    }

}