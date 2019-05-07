package game;

import board.Board;

import game.layout.PieceLayout;

import game.type.GameType;

/**
 * @author Alejandro Doberenz
 * @version 4/27/2019
 */
public class Game implements Runnable {

    // <editor-fold defaultstate="collapsed" desc="Variables"
    private GameType gameType;

    private Board board;

    private PieceLayout pieceLayout;

    private Player currentPlayer;
    // </editor-fold>

    public Game(GameType gt) {
        gameType = gt;
        pieceLayout = gameType.getPieceLayout();
        board = new Board(gameType.getXSize(),gameType.getYSize());
        pieceLayout.setGame(this);
        pieceLayout.populate();
    }

    public Board getBoard() { return board; }

    @Override public void run() {
        System.out.print("The player to go first is: ");
        if(util.Random.generate(0, 1) == 0) System.out.println("WHITE");
        else System.out.println("BLACK");
        board.consoleDrawWhite(true);
        board.consoleDrawBlack(true);
        System.out.println(board.getCell(0,0).getOccupant());
        System.out.println(board.getCell(7,7).getOccupant());
    }

}