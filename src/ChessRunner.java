import board.Board;
import game.Game;
import game.Player;
import piece.*;

/**
 * This class runs the Chess program by creating a game.
 */
public class ChessRunner {

    private static void scanBoardCell(Board b) {
        if(b.getGame().getVerbose())
            System.out.println("\t> Scanning board for occupied cells...");
        for(board.Cell[] cellArray : b.get_CellArray()) {
            for(board.Cell cell : cellArray) {
                if(cell.getIsOccupied())
                    System.out.println("\t\t" + cell + ": " + cell.getOccupant());
            }
        }
        if(b.getGame().getVerbose())
            System.out.println("\t> Board scan complete.");
    }

    public static void main(String[] args) {
        Game g1 = new Game(true,8,8);
        Player p1 = new Player(g1, "Alejandro");
        Player p2 = new Player(g1, "Quinn");
        Board gameBoard = g1.getBoard();
        Pawn pw1 = new Pawn(gameBoard, p1, 0,1,1);
        Pawn pw2 = new Pawn(gameBoard, p1, 1,1,1);
        Pawn pw3 = new Pawn(gameBoard, p1, 2,1,1);
        Pawn pw4 = new Pawn(gameBoard, p1, 3,1,1);
        Pawn pw5 = new Pawn(gameBoard, p1, 4,1,1);
        Pawn pw6 = new Pawn(gameBoard, p1, 5,1,1);
        Pawn pw7 = new Pawn(gameBoard, p1, 6,1,1);
        Pawn pw8 = new Pawn(gameBoard, p1, 7,1,1);
        King k1 = new King(gameBoard, p1,4,0);
        Rook r1 = new Rook(gameBoard, p1,0,0);
        Rook r2 = new Rook(gameBoard, p1,7,0);
        Bishop b1 = new Bishop(gameBoard, p1,2,0);
        Bishop b2 = new Bishop(gameBoard,p1,5,0);
        HorseKnight h1 = new HorseKnight(gameBoard, p1,1,0);
        HorseKnight h2 = new HorseKnight(gameBoard, p1,6,0);
        Queen q1 = new Queen(gameBoard,p1,3,0);
        gameBoard.consoleDraw();
        q1.move(3,3);
        gameBoard.consoleDraw();
    }

}