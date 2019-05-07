package game;

import piece.Piece;

import java.awt.Color;

import java.util.ArrayList;

/**
 * @author Alejandro Doberenz
 * @version 4/30/2019
 */
public class Player {

    // <editor-fold desc="Variables">
    private String name;

    private Color color;

    private ArrayList<piece.Piece> pieces = new ArrayList<>();
    // </editor-fold>

    public Player(String n, Color c) {
        name = n;
        color = c;
    }

    public void addPiece(piece.Piece piece) { pieces.add(piece); }

    public void addPieces(java.util.Collection<Piece> pieces) { this.pieces.addAll(pieces); }

    @Override public String toString() {
        return name;
    }

}