package piece;

/**
 * 1/27/2019
 * @author Alejandro Doberenz
 * @version 0.2.1
 *
 * A Pawn is a piece that is supposed to emulate the real world pawn piece in a default game of chess.
 */
public final class Pawn extends Piece {

    private int linearity;
    private boolean hasMoved;

    @Override void onMove() {
        if(!hasMoved)
            hasMoved = true;
    }

    @Override boolean pieceMoveSet(int xChg, int yChg) {
        return !(yChg*linearity <= 0 || yChg*linearity > 2 ||
            ( (xChg == 1 || xChg == -1)
                && (yChg*linearity == 1)
                && !(cell.getNearbyCell(xChg, yChg).getIsOccupied())
            ) ||
            (xChg > 1 || xChg < -1) ||
            (yChg*linearity == 2 && hasMoved));
    }

    public Pawn(board.Board b, game.Player p, int x, int y, int l) {
        super(b,p,x,y);
        linearity = l;
        hasMoved = false;
    }

}