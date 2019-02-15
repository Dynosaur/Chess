package game.layout;

import game.Game;
import piece.Piece;

import java.awt.*;

public class PieceLayout {

    private int reqX, reqY;

    private Piece[] pieces;

    private Game game;

    public String name;

    public void setGame(Game g) {
        if(g.getBoard().getX() < reqX || g.getBoard().getY() < reqY)
            throw new IllegalArgumentException("Given board is smaller than required.");
        game = g;
    }

    public void populate() {
        for(Piece piece : pieces) {
            piece.setBoard(game.getBoard());
            piece.setCell(piece.getBoard().getCell(piece.getX(), piece.getY()));
            piece.getCell().setOccupant(piece);
            if (game.getVerbose()) {
                String color = (piece.getColor() == Color.BLACK) ? "Black" : "White";
                System.out.println("\t\t\t> " + color + " " + piece.getClass().getSimpleName() + " added to the game.");
            }
        }
    }

    public PieceLayout(String n, int x, int y, Piece... p) {
        name = n;
        reqX = x;
        reqY = y;
        pieces = p;
    }

}
