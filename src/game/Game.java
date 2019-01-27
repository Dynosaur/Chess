package game;

import board.Board;

/**
 * A Game object is supposed to represent the abstract rules of a Chess game. It also determines if it should
 * tell the user what it's doing (Verbose).
 */
public class Game {

    private Board board;

    private boolean verbose;

    public Board getBoard() {
        return board;
    }
    public boolean getVerbose() {
        return verbose;
    }

    public Game(boolean v, int x, int y) {
        verbose = v;
        if(verbose)
            System.out.println("> New Game initialized.");
        board = new Board(this, x, y);
    }

}