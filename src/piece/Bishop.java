package piece;

public final class Bishop extends Piece {

    private boolean checkBishopMove(int xChg, int yChg) {
        board.Cell target = cell;
        for(int i = 0; i < xChg; i++) {
            target = target.getNearbyCell(xChg/Math.abs(xChg), yChg/Math.abs(yChg));
            if(target.getIsOccupied())
                return false;
        }
        return true;
    }
 void onMove() {}
 boolean pieceMoveSet(int xChg, int yChg) {
        return ( (xChg == yChg) && checkBishopMove(xChg, yChg) );
    }

    public Bishop(int x, int y, java.awt.Color c) {
        super(x, y, c);
    }

    public Bishop(board.Board b, game.Player p, int x, int y) {
        super(b,p,x,y);
    }

}
