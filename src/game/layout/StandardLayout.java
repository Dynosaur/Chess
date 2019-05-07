package game.layout;

import game.Player;

import piece.Bishop;

import piece.HorseKnight;

import piece.King;

import piece.Pawn;

import piece.Queen;

import piece.Rook;

import java.awt.Color;

/**
 * @author Alejandro Doberenz
 * @version 4/27/2019
 */
public class StandardLayout extends PieceLayout {

    public StandardLayout() {
        super("Standard",8,8);
        whitePieces.add(new Pawn(0,1,white));
        whitePieces.add(new Pawn(1,1,white));
        whitePieces.add(new Pawn(2,1,white));
        whitePieces.add(new Pawn(3,1,white));
        whitePieces.add(new Pawn(4,1,white));
        whitePieces.add(new Pawn(5,1,white));
        whitePieces.add(new Pawn(6,1,white));
        whitePieces.add(new Pawn(7,1,white));
        whitePieces.add(new Rook(0, 0,white));
        whitePieces.add(new HorseKnight(1,0,white));
        whitePieces.add(new Bishop(2,0,white));
        whitePieces.add(new Queen(3,0,white));
        whitePieces.add(new King(4,0,white));
        whitePieces.add(new Bishop(5,0,white));
        whitePieces.add(new HorseKnight(6,0,white));
        whitePieces.add(new Rook(7,0,white));
        blackPieces.add(new Pawn(7,6,black));
        blackPieces.add(new Pawn(6,6,black));
        blackPieces.add(new Pawn(5,6,black));
        blackPieces.add(new Pawn(4,6,black));
        blackPieces.add(new Pawn(3,6,black));
        blackPieces.add(new Pawn(2,6,black));
        blackPieces.add(new Pawn(1,6,black));
        blackPieces.add(new Pawn(0,6,black));
        blackPieces.add(new Rook(7, 7,black));
        blackPieces.add(new HorseKnight(6,7,black));
        blackPieces.add(new Bishop(5,7,black));
        blackPieces.add(new Queen(4,7,black));
        blackPieces.add(new King(3,7,black));
        blackPieces.add(new Bishop(2,7,black));
        blackPieces.add(new HorseKnight(1,7,black));
        blackPieces.add(new Rook(0,7,black));
    }

}
