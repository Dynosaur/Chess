package board;

import java.awt.Color;

import piece.Piece;

/**
 * 1/25/2019
 * @author Alejandro Doberenz
 * @version 0.2
 *
 * A Cell represents a single cell inside of a chessboard. A cell is part of a class_board, has an X and Y position,
 * a color, and a piece that is on it (Or lack thereof).
 */
public class Cell {

    private Board cell_board;           // The class_board the cell is on.

    private int xPosition, yPosition;   // The coordinates of the cell on the class_board.

    private Color cell_color;           // The cell_color of the cell.

    private Piece occupant;             // The piece occupying the cell.

    private boolean isOccupied;         // Whether the cell is occupied or not.

    // <editor-fold defaultstate="collapsed" desc="Accessor Methods">

    public Color get_Color() {
        return cell_color;
    }

    public Piece get_Occupant() {
        return occupant;
    }

    boolean get_Occupied() {
        return isOccupied;
    }

    // </editor-fold>
    // <editor-fold defaulststate="collapsed" desc="Mutator Methods">

    public void set_Occupant(Piece piece) {
        isOccupied = piece != null;
        occupant = piece;
    }

    // </editor-fold>

    @Override public String toString() {
        return "(" + xPosition + ", " + yPosition + ")";
    }

    Cell(Board board, int x, int y, Color color) {
        cell_board  = board;
        xPosition   = x;
        yPosition   = y;
        cell_color  = color;
        isOccupied  = false;

        cell_board.set_Cell(this, xPosition, yPosition);
    }

}
