package piece;

public class HorseKnight extends Piece {

    @Override void onMove() {}

    @Override boolean pieceMoveSet(int xChg, int yChg) {
        board.Cell target = cell.getNearbyCell(xChg, yChg);
        try {
            target.equals(cell.getNearbyCell(1,2));
        } catch(ArrayIndexOutOfBoundsException ex) {}
        return ( (target.equals(cell.getNearbyCell(1,2))) ||
                 (target.equals(cell.getNearbyCell(-1,2))) ||
                 (target.equals(cell.getNearbyCell(-1,-2))) ||
                 (target.equals(cell.getNearbyCell(1,-2))));
    }

    public HorseKnight(board.Board b, game.Player p, int x, int y) {
        super(b,p,x,y);
    }

}
