package board;

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

    public Board getBoard() {
        return cell_board;
    }

    public int getX() {
        return xPosition;
    }
    public int getY() {
        return yPosition;
    }

    public Piece getOccupant() {
        return occupant;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public Cell getNearbyCell(int xChange, int yChange) throws ArrayIndexOutOfBoundsException {
        return cell_board.getCell(xPosition + xChange, yPosition + yChange);
    }

    // </editor-fold>
    // <editor-fold defaulststate="collapsed" desc="Mutator Methods">

    public void setOccupant(Piece piece) {
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

        if(cell_board.getGame().getVerbose())
            System.out.println("\t\t> New Cell created: " + this);
    }

}