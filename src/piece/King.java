package piece;

/**
 * 1/27/2019
 * @author Alejandro Doberenz
 * @version 0.9.0
 */
public final class King extends Piece {

    @Override void onMove() {
    }

    @Override boolean pieceMoveSet(int xChg, int yChg) {
        return !(xChg < -1 || xChg > 1 || yChg < -1 || yChg > 1);
    }

    public King(board.Board b, game.Player p, int x, int y) {
        super(b,p,x,y);
    }

}