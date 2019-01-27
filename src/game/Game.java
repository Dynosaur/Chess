package game;

import board.Board;

/**
 * A Game object is supposed to represent the abstract rules of a Chess game. It also determines if it should
 * tell the user what it's doing (Verbose).
 */
public class Game {

    private Board gameBoard;

    private boolean verbose;

    public Board get_Board() {
        return gameBoard;
    }
    public boolean get_verbose() {
        return verbose;
    }

    public Game(boolean v, int x, int y) {
        verbose = v;
        if(verbose)
            System.out.println("> New Game initialized.");
        gameBoard = new Board(this, x, y);
    }

}
