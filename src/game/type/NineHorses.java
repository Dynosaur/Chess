package game.type;

import game.Player;

import game.layout.NineHorsesLayout;

public class NineHorses extends GameType {

    public NineHorses() {
        super("Nine Horses","Nine horses on each side. To win, enter the middle cell and exit it.",
        9,9, new NineHorsesLayout());
        whitePlayer.addPieces(pieceLayout.getWhitePieces());
        blackPlayer.addPieces(pieceLayout.getBlackPieces());
    }

}
