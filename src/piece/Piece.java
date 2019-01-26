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

    protected abstract void move(int xChange, int yChange);
    protected abstract void capture(int xChange, int yChange);
    void getCaptured() {
        isCaptured = true;
        cell.set_Occupant(null);
        cell = null;
    }

    Piece() {
        isCaptured = false;
    }
    Piece(Board board, int x, int y) {
        this.class_board = board;
        xPosition = x;
        yPosition = y;
        cell = this.class_board.get_Cell(xPosition, yPosition);
        cell.set_Occupant(this);
        isCaptured = false;
    }

}
