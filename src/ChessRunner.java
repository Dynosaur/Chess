import board.Board;
import game.*;
import game.PieceLayout;
import game.Player;
import game.StandardLayout;
import piece.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class ChessRunner {

    private static GameType gameType;
    private static PieceLayout gameLayout;
    private static boolean gameVerbosity;
    private static StandardChess standard = new StandardChess();

    private static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("< ");
        return scanner.nextLine();
    }
    private static int getIntInput() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("< ");
            try {
                return scanner.nextInt();
            } catch(InputMismatchException ex) {
                System.out.println("Please enter a number.");
            }
        }
    }
    private static void help() {
        System.out.println("----------------------------------------" +
        "\n\tBACK\tGoes back an input loop\n\tEXIT\tExits the program\n" +
        "----------------------------------------");
    }
    private static void layout() {
        layoutLoop: while(true) {
            System.out.println("\n\tLAYOUT OPTIONS");
            String input = getStringInput();
            switch(input) {
                case "back":
                    break layoutLoop;
                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "help":
                    help();
                    break;
                default:
                    System.out.println("\'" + input + "\' is not an available option.");
                    break;
            }
        }
    }
    private static void verbosity() {
        System.out.println("\n\tVERBOSITY OPTIONS\n" +
                "");
    }
    private static void newGame() {
        gameType = standard;
        gameLayout = gameType.getPieceLayout();
        gameVerbosity = false;
        newGameLoop: while(true) {
            System.out.println("\n\t\tOPTIONS\n" +
            "\tGAME TYPE\t" + gameType.name + "\n" +
            "\tLAYOUT\t\t" + gameLayout.name + "\n" +
            "\tVERBOSITY\t" + ((gameVerbosity) ? "On" : "Off") + "\n");
            String input = getStringInput();
            switch(input.toLowerCase()) {
                case "back":
                    break newGameLoop;
                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "layout":
                    layout();
                    break;
                case "help":
                    help();
                    break;
                case "verbosity":
                    verbosity();
                    break;
                default:
                    System.out.println("\'" + input + "\' is not an available option.");
                    break;
            }
        }
    }
    private static void run() {
        System.out.println("Chess v0.3ish\n");
        System.out.println("Enter \'help\' for a list of commands.");
        while(true) {
            System.out.println("\n\t\tMAIN MENU\n" +
            "\n\tNEW GAME\tCreate a new game\n");
            String input = getStringInput();
            switch(input.toLowerCase()) {
                case "back":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "help":
                    help();
                    break;
                case "new game":
                    newGame();
                    break;
                default:
                    System.out.println("\'" + input + "\' is not an available option.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        run();
    }

}