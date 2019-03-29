package board;

import piece.Piece;

/**
 * @author Alejandro Doberenz
 * @version 3/26/2019
 *
 * A Cell represents a single cell inside of a chessboard. A cell is part of a board, has an X and Y position,
 * and a piece (or not) upon it.
 */
public final class Cell {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private boolean isOccupied;     // Whether the cell is occupied or not.

    private int xPos, yPos;         // The coordinates of the cell on the board.

    private Board board;            // The board the cell is on.

    private Piece occupant;         // The piece occupying the cell.
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

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public boolean getIsOccupied() { return isOccupied; }

    public int getX() { return xPos; }

    public int getY() { return yPos; }

    public Board getBoard()     { return board; }

    public Cell getNearbyCell(int xChange, int yChange) throws ArrayIndexOutOfBoundsException { return board.getCell(xPos + xChange, yPos + yChange); }

    public Piece getOccupant()  { return occupant; }

    public void setOccupant(Piece piece) {
        isOccupied = piece != null;
        occupant = piece;
    }
    // </editor-fold>

}