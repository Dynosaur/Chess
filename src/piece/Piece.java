package piece;

import board.Board;
import board.Cell;

/**
 * 1/25/2019
 * @author Alejandro Doberenz
 * @version 0.1
 *
 * A Piece is an object that can be placed upon a chess board.
 */
public abstract class Piece {

    int                     xPosition, yPosition;
    boolean                 isCaptured;
    Board                   class_board;
    Cell                    cell;
    public game.Player      class_player;

    protected abstract void move(int xChange, int yChange);
    protected abstract void capture(int xChange, int yChange);
    void getCaptured() {
        isCaptured = true;
        cell.set_Occupant(null);
        cell = null;
    }

    @Override public String toString() {
        return getClass().getSimpleName() + ", (" + xPosition + ", " + yPosition + "), " + class_player;
    }

    Piece() {
        isCaptured = false;
    }
    Piece(Board board, game.Player player, int x, int y) {
        this.class_board = board;
        xPosition = x;
        yPosition = y;
        cell = this.class_board.get_Cell(xPosition, yPosition);
        cell.set_Occupant(this);
        class_player = player;
        isCaptured = false;
        if(cell.get_Board().get_game().get_verbose()) {
            System.out.println("\t\t\t> New " + getClass().getSimpleName() + " belonging to " + class_player + " successfully created at " + cell + ".");
        }
    }

}
