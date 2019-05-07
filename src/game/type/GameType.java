package game.type;

import game.Player;

import game.layout.PieceLayout;

/**
 * @author Alejandro Doberenz
 * @version 4/27/2019
 */
public abstract class GameType {

    // <editor-fold desc="Variables">
    public String name, description;

    private int boardXSize, boardYSize;

    protected PieceLayout pieceLayout;

    protected Player whitePlayer = new Player("white", java.awt.Color.WHITE);

    protected Player blackPlayer = new Player("black", java.awt.Color.BLACK);
    // </editor-fold>

    public GameType(String n, String desc, int x, int y, PieceLayout pl) {
        name = n;
        description = desc;
        boardXSize = x;
        boardYSize = y;
        pieceLayout = pl;
    }

    // <editor-fold desc="Accessor and Mutator Methods">
    public int getXSize() { return boardXSize; }

    public int getYSize() { return boardYSize; }

    public PieceLayout getPieceLayout() { return pieceLayout; }

    public Player getWhitePlayer() { return whitePlayer; }

    public Player getBlackPlayer() { return blackPlayer; }
    // </editor-fold>

}
