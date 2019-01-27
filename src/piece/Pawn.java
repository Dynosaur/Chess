package piece;

/**
 * 1/26/2019
 * @author Alejandro Doberenz
 * @version 0.2.0
 *
 * A Pawn is a piece that is supposed to emulate the real world pawn piece in a default game of chess.
 */
public final class Pawn extends Piece {

    private boolean hasMoved;

    private int checkMove(int xChange, int yChange) {
        if(xChange != 0) {
            System.err.println("xChange is " + xChange + "\nPawns cannot move left or right.");
            return 0;
        }
        if(yChange <= 0) {
            System.err.println("yChange is " + yChange + "\nPawns must always move forward.");
            return 0;
        }
        if(yChange > 2) {
            System.err.println("yChange is " + yChange + "\nPawns can never move more than 2 cells forward.");
            return 0;
        }
        if(yChange == 2 && hasMoved) {
            System.err.println("yChange is " + yChange + "\nPawns can only move forward 2 cells on their first move.");
            return 0;
        }
        board.Cell target = null;
        try {
            target = cell.get_Board().get_Cell(cell.get_X()+xChange, cell.get_Y()+yChange);
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.err.println("\t\t\t\tTarget cell is not on the board.");
            return 0;
        }
        if(target.get_Occupied()) {
            System.err.println("\t\t\t\tTarget cell " + target + " is occupied (Use capture()).");
            return -1;
        }
        return 1;
    }
    private boolean checkCapture(int xChange, int yChange) {
        if(xChange == 0) {
            System.err.println("xChange is " + xChange + "\nPawns can only capture diagonally.");
            return false;
        }
        if(yChange != 1) {
            System.err.println("yChange is " + yChange + "\nPawns can only capture one cell away from them.");
            return false;
        }
        if(xChange < -1 || xChange > 1) {
            System.err.println("xChange is " + xChange + "\nPawns can only capture one tile away.");
            return false;
        }
        return true;
    }

    @Override
    public void move(int xChange, int yChange) {
        if(cell.get_Board().get_game().get_verbose()) {
            System.out.println("\t\t\t> Attempting to move " + this + " by (" + xChange + ", " + yChange + ").");
        }
        switch(checkMove(xChange, yChange)) {
            case -1:
                System.out.println("\t\t\t> There is a piece at the target cell " + cell.get_Nearby(xChange, yChange) +", do you want to capture it?");

                break;
            case 0:
                System.out.println("\t\t\t> Attempt failed.");
                break;
            case 1:
                cell.set_Occupant(null);
                xPosition += xChange;
                yPosition += yChange;
                cell = class_board.get_Cell(xPosition, yPosition);
                cell.set_Occupant(this);
                if(!hasMoved)
                    hasMoved = true;
                if(cell.get_Board().get_game().get_verbose())
                    System.out.println("\t\t\t> Attempt successful.");
                break;
        }
    }
    @Override
    public void capture(int xChange, int yChange) {
        if(cell.get_Board().get_game().get_verbose()) {
            System.out.println("\t\t\t> Attempting to capture with " + this + " by (" + xChange + ", " + yChange + ").");
        }
        if(checkCapture(xChange, yChange)) {
            System.out.println("\t\t\t> Attempt successful.");
        } else {
            System.out.println("\t\t\t> Attempt failed.");
        }
    }

    public Pawn(board.Board board, game.Player player, int x, int y) {
        super(board, player, x, y);
        hasMoved = false;
    }

}
