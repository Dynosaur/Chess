package board;

import java.awt.Color;

import piece.Piece;

/**
 * 1/26/2019
 * @author Alejandro Doberenz
 * @version 0.2
 *
 * A Cell represents a single cell inside of a chessboard. A cell is part of a class_board, has an X and Y position,
 * a color, and a piece that is on it (Or lack thereof).
 */
public class Cell {

    private Board cell_board;           // The class_board the cell is on.

    private int xPosition, yPosition;   // The coordinates of the cell on the class_board.

    private Piece occupant;             // The piece occupying the cell.

    private boolean isOccupied;         // Whether the cell is occupied or not.

    // <editor-fold defaultstate="collapsed" desc="Accessor Methods">

    public Board get_Board() {
        return cell_board;
    }

    public int get_X() {
        return xPosition;
    }
    public int get_Y() {
        return yPosition;
    }

    public Piece get_Occupant() {
        return occupant;
    }

    public boolean get_Occupied() {
        return isOccupied;
    }

    public Cell get_Nearby(int xChange, int yChange) throws ArrayIndexOutOfBoundsException {
        return cell_board.get_Cell(xPosition + xChange, yPosition + yChange);
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

    Cell(Board board, int x, int y) {
        cell_board  = board;
        xPosition   = x;
        yPosition   = y;
        isOccupied  = false;

        cell_board.set_Cell(this, xPosition, yPosition);

        if(cell_board.get_game().get_verbose())
            System.out.println("\t\t> New Cell created: " + this);
    }

}
