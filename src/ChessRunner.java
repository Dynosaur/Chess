import board.Board;
import game.Game;
import game.Player;
import piece.Pawn;

public class ChessRunner {

    private static void scanBoardCell(Board b) {
        if(b.get_game().get_verbose())
            System.out.println("\t> Scanning board for occupied cells...");
        for(board.Cell[] cellArray : b.get_CellArray()) {
            for(board.Cell cell : cellArray) {
                if(cell.get_Occupied())
                    System.out.println("\t\t" + cell + ": " + cell.get_Occupant());
            }
        }
        if(b.get_game().get_verbose())
            System.out.println("\t> Board scan complete.");
    }

    public static void main(String[] args) {
        Game g1 = new Game(true,6,6);
        Player p1 = new Player(g1, "Alejandro", java.awt.Color.WHITE);
        Player p2 = new Player(g1, "Quinn", java.awt.Color.BLACK);
        Board gameBoard = g1.get_Board();
        Pawn pw1 = new Pawn(gameBoard, p1, 3, 3);
        Pawn pw2 = new Pawn(gameBoard, p2, 2, 2);
        gameBoard.consoleDraw();
        pw2.move(1, 1);
        gameBoard.consoleDraw();
        scanBoardCell(gameBoard);
    }

}
