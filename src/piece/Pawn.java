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

     public boolean validate(int xChg, int yChg) {
         return false;
    }

    void onMove() {
        if(!hasMoved)
            hasMoved = true;
    }

    boolean pieceMoveSet(int xChg, int yChg) {
        if(yChg*linearity < 0 || yChg*linearity > 2) {
            return false;
        }
        if(xChg > 1 || xChg < -1) {
            return false;
        }
        if(xChg == 1 || xChg == -1 && yChg*linearity == 1 && !cell.getNearbyCell(xChg,yChg).getIsOccupied()) {
            return false;

        }
        if(yChg*linearity == 2 && hasMoved) {
            return false;
        }
        return true;
    }

    public Pawn(int x, int y, java.awt.Color c) {
        super(x, y, c);
    }

    public Pawn(board.Board b, game.Player p, int x, int y, int l) {
        super(b,p,x,y);
        linearity = l;
        hasMoved = false;
    }

}