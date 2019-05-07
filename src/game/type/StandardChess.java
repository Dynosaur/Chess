package game.type;

import game.layout.StandardLayout;

public class StandardChess extends GameType {

    public StandardChess() {
        super("Standard","Standard Chess game.",8,8, new StandardLayout());
        whitePlayer.addPieces(pieceLayout.getWhitePieces());
        blackPlayer.addPieces(pieceLayout.getBlackPieces());
    }

}
