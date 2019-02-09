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
        if(yChg*linearity < 0 || yChg*linearity > 2) {
            if(board.getGame().getVerbose())
                System.out.println("Failed: yChg");
            return false;
        }
        if(xChg > 1 || xChg < -1) {
            if(board.getGame().getVerbose())
                System.out.println("Failed: xChg");
            return false;
        }
        if(xChg == 1 || xChg == -1 && yChg*linearity == 1 && !cell.getNearbyCell(xChg,yChg).getIsOccupied()) {
            if(board.getGame().getVerbose())
                System.out.println("Failed: Move would be legal if target was occupied");
            return false;

        }
        if(yChg*linearity == 2 && hasMoved) {
            if(board.getGame().getVerbose())
                System.out.println("Move would be legal if you hadn't moved already.");
            return false;
        }
        return true;
    }

    public Pawn(java.awt.Color c, int x, int y) {
        super(c,x,y);
    }
    public Pawn(board.Board b, game.Player p, int x, int y, int l) {
        super(b,p,x,y);
        linearity = l;
        hasMoved = false;
    }

}