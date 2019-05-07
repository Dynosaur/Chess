package piece;

import board.Board;

import board.Cell;

import game.Player;

import java.awt.Color;

/**
 * @author Alejandro Doberenz
 * @version 4/27/2019
 */
public abstract class Piece implements Cloneable {

    int xPosition, yPosition;

    private Board board;

    Cell cell;

    private Player player;

    private Color pieceColor;

    public Piece(int x, int y, Color color) {
        xPosition = x;
        yPosition = y;
        pieceColor = color;
    }

    public Piece(Board b, Player p, int x, int y) {
        board = b;
        player = p;
        xPosition = x;
        yPosition = y;
        cell = board.getCell(xPosition, yPosition);
        cell.setOccupant(this);
    }

    @Override public String toString() {
        return "(" + ((pieceColor.equals(Color.WHITE)) ? "White " : "Black ") + getClass().getSimpleName() + ", (" + xPosition + ", " + yPosition + "), " + player + ")";
    }

    public int getX()               { return xPosition; }
    public int getY()               { return yPosition; }

    public Board getBoard()         { return board; }
    public void setBoard(Board b)   { board = b; }

    public Cell getCell()           { return cell; }
    public void setCell(Cell c)     { cell = c; }

    public Color getColor()         { return pieceColor; }

}