package game;

import piece.Piece;

import java.awt.*;

public class PieceLayout {

    Piece[] pieces;

    private Game game;

    public PieceLayout(int xSize, int ySize, Game g, Piece... p) {
        if(g.getBoard().getX() != xSize || g.getBoard().getY() != ySize)
            throw new IllegalArgumentException("Board is incorrect size.");
        pieces = p;
        game = g;
    }

    void populate() {
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

}
