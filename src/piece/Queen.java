package piece;

import board.Board;
import game.Player;

public final class Queen extends Piece {

     void onMove() {}

     boolean pieceMoveSet(int xChg, int yChg) {
        if((xChg == 0 && yChg != 0) || (xChg != 0 && yChg == 0)) {
            board.Cell target;
            if(xChg == 0) {
                for(int y = yChg; y > 0; y--) {
                    target = cell.getNearbyCell(0, yChg / Math.abs(yChg));
                    if(target.getIsOccupied())
                        return false;
                }
                return true;
            } else {
                for(int x = xChg; x > 0; x--) {
                    target = cell.getNearbyCell(xChg/Math.abs(xChg),0);
                    if(target.getIsOccupied())
                        return false;
                }
                return true;
            }
        }
        if(xChg == yChg) {
            board.Cell target;
            for(int i = xChg; i > 0; i--) {
                target = cell.getNearbyCell(xChg/Math.abs(xChg),yChg/Math.abs(yChg));
                if(target.getIsOccupied())
                    return false;
            }
            return true;
        }
        return false;
    }

    public Queen(int x, int y, java.awt.Color c) {
        super(x, y, c);
    }

    public Queen(Board b, Player p, int x, int y) {
        super(b,p,x,y);
    }

}
