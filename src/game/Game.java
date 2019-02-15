package game;

import board.Board;
import game.layout.PieceLayout;
import game.type.GameType;

/**
 * 2/10/2019
 * @author Alejandro Doberenz
 * @version 0.25
 *
 * A Game object is supposed to represent all the components of a chess game. This includes the rules, the size
 * of the board used, where the pieces are placed, and some other program functions.
 */
public class Game {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private boolean verbose;

    private GameType gameType;

    private Board board;

    private PieceLayout pieceLayout;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Accessor Methods">
    public Board getBoard() {
        return board;
    }
    public boolean getVerbose() {
        return verbose;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mutator Methods">
    public void setPieceLayout(PieceLayout pl) {
        pieceLayout = pl;
        if(verbose)
            System.out.println("> " + pieceLayout.getClass().getSimpleName() + " placing pieces...");
        pieceLayout.populate();
    }
    // </editor-fold>

    public Game(boolean v, GameType gt) {
        verbose = v;
        gameType = gt;
        if(verbose)
            System.out.println("> New Game initialized.");
        board = new Board(this,gameType.getXSize(),gameType.getYSize());
    }

}