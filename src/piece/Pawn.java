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

    @Override boolean pieceMoveSet(int xChg, int yChg) {
        return ((xChg == 1 && cell.getNearbyCell(1, 0).getIsOccupied()) ||
                (xChg == -1 && cell.getNearbyCell(-1, 0).getIsOccupied()) ||
                (yChg != 0) || !(yChg*linearity > 2));
    }

    public Pawn(board.Board b, game.Player p, int x, int y, int l) {
        super(b, p, x, y);
        linearity = l;
        hasMoved = false;
    }

}