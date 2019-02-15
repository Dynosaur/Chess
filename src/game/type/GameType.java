package game.type;

import game.layout.PieceLayout;

public abstract class GameType {

    public String name, description;

    private int boardXSize, boardYSize;

    private PieceLayout pieceLayout;

    public int getXSize() {
        return boardXSize;
    }
    public int getYSize() {
        return boardYSize;
    }
    public PieceLayout getPieceLayout() {
        return pieceLayout;
    }

    public GameType(String n, String desc, int x, int y, PieceLayout pl) {
        name = n;
        description = desc;
        boardXSize = x;
        boardYSize = y;
        pieceLayout = pl;
    }

}
