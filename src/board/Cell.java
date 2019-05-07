package board;

import piece.Piece;

/**
 * @author Alejandro Doberenz
 * @version 4/27/2019
 */
public final class Cell implements Cloneable {

    // <editor-fold desc="Variables">
    private int xPos, yPos;

    private Board board;

    private boolean isOccupied;

    private Piece occupant;
    // </editor-fold>

    Cell(Board b, int x, int y) {
        board = b;
        xPos = x;
        yPos = y;
        isOccupied = false;
        board.setCell(this, xPos, yPos);
    }

    // <editor-fold defaultstate="collapsed" desc="Accessor and Mutator Methods">
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

    @Override public boolean equals(Object obj) {
        if(!(obj instanceof Cell)) return false;
        Cell cell = (Cell) obj;
        return cell.board == board && cell.xPos == xPos && cell.yPos == yPos;
    }

    @Override public String toString() {
        return "(" + xPos + ", " + yPos + ")";
    }
}
