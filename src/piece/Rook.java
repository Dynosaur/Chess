package piece;

public final class Rook extends Piece {

    private boolean checkYMove(int yChg) {
        board.Cell tile = cell;
        for(int i = yPos; i < yChg; i++) {
            tile = tile.getNearbyCell(0,1);
            if(tile.getIsOccupied())
                return false;
        }
        return true;
    }
    private boolean checkXMove(int xChg) {
        board.Cell target = cell;
        for(int i = xPos; i < xChg; i++) {
            target = target.getNearbyCell(1,0);
            if(target.getIsOccupied())
                return false;
        }
        return true;
    }

    @Override void onMove() {}

    @Override boolean pieceMoveSet(int xChg, int yChg) {
        if(xChg == xPos)
            return checkYMove(yChg);
        if(yChg == yPos)
            return checkXMove(xChg);
        return xChg != xPos && yChg != yPos;
    }

    public Rook(board.Board b, game.Player p, int x, int y) {
        super(b,p,x,y);
    }

}
