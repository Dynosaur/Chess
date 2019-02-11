package game;

public abstract class GameType {

    public String name;

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

    public GameType(String n, int x, int y, PieceLayout pl) {
        name = n;
        boardXSize = x;
        boardYSize = y;
        pieceLayout = pl;
    }

}
