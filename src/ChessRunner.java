import board.Board;
import game.Game;
import piece.Pawn;

public class ChessRunner {

    public static void main(String[] args) {
        Game game1 = new Game(6,6);
        Board gameBoard = game1.getBoard();
        new Pawn(gameBoard, 0, 0);
        gameBoard.consoleDraw();
    }

}
