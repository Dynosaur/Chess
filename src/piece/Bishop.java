package piece;

public class Bishop extends Piece {

    private boolean checkBishopMove(int xChg, int yChg) {
        board.Cell target = cell;
        for(int i = 0; i < xChg; i++) {
            target = target.getNearbyCell(xChg/Math.abs(xChg), yChg/Math.abs(yChg));
            if(target.getIsOccupied())
                return false;
        }
        return true;
    }

    @Override void onMove() {}

    @Override boolean pieceMoveSet(int xChg, int yChg) {
        return ( (xChg == yChg) && checkBishopMove(xChg, yChg) );
    }

    public Bishop(board.Board b, game.Player p, int x, int y) {
        super(b,p,x,y);
    }

}
