package piece;

/**
 * 1/25/2019
 * @author Alejandro Doberenz
 * @version 0.15
 *
 * A Pawn is a piece that is supposed to emulate the real world pawn piece in a default game of chess.
 */
public final class Pawn extends Piece {

    private boolean hasMoved;

    @Override
    protected void move(int xChange, int yChange) {
        if(xChange != 0)
            throw new IllegalArgumentException("xChange: " + xChange + "\nPawns cannot move left or right.");
        /*
        if(xChange < -1)
            throw new IllegalArgumentException("xChange: " + xChange + "\nPawns cannot move more than one space to the left.");
        if(xChange > 1)
            throw new IllegalArgumentException("xChange: " + xChange + "\nPawns cannot move more than one space to the right.");
        */
        if(yChange <= 0)
            throw new IllegalArgumentException("yChange: " + yChange + "\nPawns must always move forward.");
        if(yChange > 2)
            throw new IllegalArgumentException("yChange: " + yChange + "\nPawns cannot move more than two spaces forward.");
        if(yChange == 2 && hasMoved)
            throw new IllegalArgumentException("yChange: " + yChange + "\nhasMoved: " + hasMoved + "\nPawns can only move forward two spaces on their first move.");
        xPosition += xChange;
        yPosition += yChange;
        cell = class_board.get_Cell(xPosition, yPosition);
        cell.set_Occupant(this);
        if(!hasMoved)
            hasMoved = true;
    }
    @Override
    protected void capture(int xChange, int yChange) {
        if(xChange == 0 || xChange < -1 || xChange > 1)
            throw new IllegalArgumentException("xChange: " + xChange);
        if(yChange != 1)
            throw new IllegalArgumentException("yChange: " + yChange);
        xPosition += xChange;
        yPosition += yChange;
        cell = class_board.get_Cell(xPosition, yPosition);
        cell.get_Occupant().getCaptured();
        cell.set_Occupant(this);
    }

    public Pawn() {
        super();
        hasMoved = false;
    }
    public Pawn(board.Board board, int x, int y) {
        super(board, x, y);
        hasMoved = false;
    }

}
