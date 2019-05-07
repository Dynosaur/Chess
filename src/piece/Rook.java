package piece;

public final class Rook extends Piece {

    private boolean checkYMove(int yChg) {
        board.Cell tile = cell;
        for(int i = yPosition; i < yChg; i++) {
            tile = tile.getNearbyCell(0,1);
            if(tile.getIsOccupied())
                return false;
        }
        return true;
    }
    private boolean checkXMove(int xChg) {
        board.Cell target = cell;
        for(int i = xPosition; i < xChg; i++) {
            target = target.getNearbyCell(1,0);
            if(target.getIsOccupied())
                return false;
        }
        return true;
    }

 void onMove() {}
 boolean pieceMoveSet(int xChg, int yChg) {
        if(xChg == xPosition)
            return checkYMove(yChg);
        if(yChg == yPosition)
            return checkXMove(xChg);
        return xChg != xPosition && yChg != yPosition;
    }

    public Rook(int x, int y, java.awt.Color c) {
        super(x, y, c);
    }

    public Rook(board.Board b, game.Player p, int x, int y) {
        super(b,p,x,y);
    }

}
