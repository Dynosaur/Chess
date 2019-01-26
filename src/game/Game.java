package game;

import board.Board;

public class Game {

    private Board gameBoard;

    public Board getBoard() {
        return gameBoard;
    }

    public Game(int x, int y) {
        gameBoard = new Board(x, y);
    }

}
