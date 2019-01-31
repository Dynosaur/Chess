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

    private Board board;           // The class_board the cell is on.

    private int xPos, yPos;   // The coordinates of the cell on the class_board.

    private Piece occupant;             // The piece occupying the cell.

    private boolean isOccupied;         // Whether the cell is occupied or not.

    // <editor-fold defaultstate="collapsed" desc="Accessor Methods">

    public Board getBoard() {
        return board;
    }

    public int getX() {
        return xPos;
    }
    public int getY() {
        return yPos;
    }

    public Piece getOccupant() {
        return occupant;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public Cell getNearbyCell(int xChange, int yChange) throws ArrayIndexOutOfBoundsException {
        return board.getCell(xPos + xChange, yPos + yChange);
    }

    // </editor-fold>
    // <editor-fold defaulststate="collapsed" desc="Mutator Methods">

    public void setOccupant(Piece piece) {
        isOccupied = piece != null;
        occupant = piece;
    }

    // </editor-fold>

    public boolean equals(Cell cell) {
        return cell.board == board && cell.xPos == xPos && cell.yPos == yPos;
    }

    @Override public String toString() {
        return "(" + xPos + ", " + yPos + ")";
    }

    Cell(Board b, int x, int y) {
        board = b;
        xPos = x;
        yPos = y;
        isOccupied  = false;

        board.set_Cell(this, xPos, yPos);

        if(board.getGame().getVerbose())
            System.out.println("\t\t> New Cell created: " + this);
    }

}