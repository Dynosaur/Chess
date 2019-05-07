package game.layout;

import game.Game;

import piece.Piece;

import java.awt.Color;

import java.util.ArrayList;

/**
 * @author Alejandro Doberenz
 * @version 4/27/2019
 */
public class PieceLayout {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private int requiredXSize, requiredYSize;

    private Game game;

    private String name;

    protected ArrayList<Piece> whitePieces = new ArrayList<>();

    protected ArrayList<Piece> blackPieces = new ArrayList<>();

    protected static Color white = Color.WHITE;

    protected static Color black = Color.BLACK;
    // </editor-fold>

    public PieceLayout(String n, int x, int y) {
        name = n;
        requiredXSize = x;
        requiredYSize = y;
    }

    public ArrayList<Piece> getWhitePieces() { return whitePieces; }

    public ArrayList<Piece> getBlackPieces() { return blackPieces; }

    public void setGame(Game g) {
        if(g.getBoard().getX() < requiredXSize || g.getBoard().getY() < requiredYSize)
            throw new IllegalArgumentException("Given board is smaller than required.");
        game = g;
    }

    public void populate() {
        for(Piece piece : whitePieces) {
            piece.setBoard(game.getBoard());
            piece.setCell(piece.getBoard().getCell(piece.getX(), piece.getY()));
            piece.getCell().setOccupant(piece);
        }
        for(Piece piece : blackPieces) {
            piece.setBoard(game.getBoard());
            piece.setCell(piece.getBoard().getCell(piece.getX(), piece.getY()));
            piece.getCell().setOccupant(piece);
        }
    }

}
