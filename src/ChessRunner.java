import board.Board;
import game.Game;
import game.Player;
import piece.*;

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
        Player p1 = new Player(g1, "Alejandro", java.awt.Color.WHITE);
        Player p2 = new Player(g1, "Quinn", java.awt.Color.BLACK);
        Board gameBoard = g1.getBoard();
        Pawn pw1 = new Pawn(gameBoard, p1, 1, 1, 1);
        gameBoard.consoleDraw();
        pw1.move(0, 3);
        gameBoard.consoleDraw();
    }

}