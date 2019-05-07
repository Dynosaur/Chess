package game.layout;

import piece.HorseKnight;

import java.awt.Color;

/**
 * @author Alejandro Doberenz
 * @version 4/30/2019
 */
public class NineHorsesLayout extends PieceLayout {

    public NineHorsesLayout() {
        super("Nine Horses",9,9);
        whitePieces.add(new HorseKnight(0,0,white));
        whitePieces.add(new HorseKnight(1,0,white));
        whitePieces.add(new HorseKnight(2,0,white));
        whitePieces.add(new HorseKnight(3,0,white));
        whitePieces.add(new HorseKnight(4,0,white));
        whitePieces.add(new HorseKnight(5,0,white));
        whitePieces.add(new HorseKnight(6,0,white));
        whitePieces.add(new HorseKnight(7,0,white));
        whitePieces.add(new HorseKnight(8,0,white));
        blackPieces.add(new HorseKnight(0,8,black));
        blackPieces.add(new HorseKnight(1,8,black));
        blackPieces.add(new HorseKnight(2,8,black));
        blackPieces.add(new HorseKnight(3,8,black));
        blackPieces.add(new HorseKnight(4,8,black));
        blackPieces.add(new HorseKnight(5,8,black));
        blackPieces.add(new HorseKnight(6,8,black));
        blackPieces.add(new HorseKnight(7,8,black));
        blackPieces.add(new HorseKnight(8,8,black));
    }

}
