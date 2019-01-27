package piece;

import board.Board;
import board.Cell;
import game.Player;

/**
 * 1/27/2019
 * @author Alejandro Doberenz
 * @version 0.3.1
 *
 * A Piece is an object that comprises of game pieces meant to be placed upon the board and moved.
 */
public abstract class Piece {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private int xPos, yPos;     // The X and Y position of the piece

    private boolean isCaptured; // Whether the piece is captured or not

    private Board board;        // The board the piece is on
    Cell cell;          // The cell the piece is on
    private Player player;      // The player the piece belongs to
    // </editor-fold>

    /**
     * An abstract method for subclasses to define their rules on movement.
     * @param xChg The change in x from the current cell
     * @param yChg The change in y from the current cell
     * @return If the piece, abiding by its movement laws, can move to the target cell.
     */
    abstract boolean pieceMoveSet(int xChg, int yChg);

    /**
     * Ensures that the move is not on the current cell, that the target cell is on the board, that, there are no
     * friendly pieces on the target cell, and follows the movement protocol for that piece.
     * @param xChg The change in x from the current cell
     * @param yChg The change in y from the current cell
     * @return If the piece can move to the target cell.
     */
    private boolean isValidMove(int xChg, int yChg) {
        if(xChg == 0 && yChg == 0)
            return false;
        Cell target;
        try {
            target = cell.getNearbyCell(xChg, yChg);
        } catch(ArrayIndexOutOfBoundsException ex) {
            return false;
        }
        if(target.getIsOccupied())
            if(target.getOccupant().player == (player))
                return false;
        return pieceMoveSet(xChg, yChg);
    }

    /**
     * Commands a piece to move to a cell x and y cells away from it
     * @param xChg How far the piece should move along the x-axis
     * @param yChg How far the piece should move along the y-axis
     */
    public final void move(int xChg, int yChg) {
        if(board.getGame().getVerbose())
            System.out.println("\t\t\t> Attempting to move " + this + " by (" + xChg + ", " + yChg + ") units.");

        if(!isCaptured) {
            if(isValidMove(xChg, yChg)) {
                Cell target = cell.getNearbyCell(xChg, yChg);
                if(target.getIsOccupied())
                    target.getOccupant().captured();
                cell.setOccupant(null);
                xPos += xChg;
                yPos += yChg;
                cell = cell.getNearbyCell(xChg, yChg);
                cell.setOccupant(this);
                if(board.getGame().getVerbose())
                    System.out.println("\t\t\t> Attempt successful.");
                return;
            }
        }
        if(board.getGame().getVerbose())
            System.out.println("\t\t\t> Attempt failed.");
    }

    /**
     * Called when the piece is captured by another piece from the move(int, int) method.
     */
    private void captured() {
        if(board.getGame().getVerbose())
            System.out.println("\t\t\t> " + this + " has been captured!");
        isCaptured = true;
        cell.setOccupant(null);
        cell = null;
    }

    @Override public String toString() {
        return "(" + getClass().getSimpleName() + ", (" + xPos + ", " + yPos + "), " + player + ")";
    }

    Piece(Board b, Player p, int x, int y) {
        board = b; xPos = x; yPos = y;
        player = p; isCaptured = false;
        cell = board.getCell(xPos, yPos);
        cell.setOccupant(this);
        if(board.getGame().getVerbose()) {
            System.out.println("\t\t\t> New " + getClass().getSimpleName() + " belonging to " + player + " successfully created at " + cell + ".");
        }
    }

}