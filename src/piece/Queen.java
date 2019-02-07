package piece;

import board.Board;
import game.Player;

public class Queen extends Piece {

    @Override void onMove() {}

    @Override boolean pieceMoveSet(int xChg, int yChg) {
        if(xChg == yChg) {
            board.Cell target = cell;
            for(int i = 0; i < xChg; i++) {
                target = target.getNearbyCell(xChg/Math.abs(xChg), yChg/Math.abs(yChg));
                if(target.getIsOccupied())
                    return false;
                else
                    System.out.println("target is not occupied");
            }
        }
        if((xChg == 0 && yChg != 0) || (xChg != 0 && yChg == 0)) {
            board.Cell target = cell;
            for(int i = xPos; i < xChg; i++) {
                target = target.getNearbyCell(1,0);
                if(target.getIsOccupied())
                    return false;
                else
                    System.out.println("target is not occupied");
            }
        }
        return true;
    }

    public Queen(Board b, Player p, int x, int y) {
        super(b,p,x,y);
    }

}
