package game;

import piece.Piece;

public class PieceLayout {

    private Piece[] pieces;

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
        }
    }

}
