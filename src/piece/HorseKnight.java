package piece;

public class HorseKnight extends Piece {

    @Override void onMove() {}

    @Override boolean pieceMoveSet(int xChg, int yChg) {
        return ( (Math.abs(xChg) == 2 && Math.abs(yChg) == 1) || (Math.abs(xChg) == 1 && Math.abs(yChg) == 2) );
    }

    public HorseKnight(board.Board b, game.Player p, int x, int y) {
        super(b,p,x,y);
    }

}
