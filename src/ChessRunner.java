import board.Board;
import game.Game;
import game.Player;
import game.StandardLayout;
import piece.*;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class runs the Chess program by creating a game.
 */
public class ChessRunner {

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
    private static void newGame() {
        newGameLoop: while(true) {
            System.out.println("\n\t\tOPTIONS\n\tLAYOUT\tStandard\n");
            String input = getStringInput();
            switch(input) {
                case "back":
                    break newGameLoop;
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
    private static void run() {
        System.out.println("Chess v0.3ish\n");
        System.out.println("Enter \'help\' for a list of commands.");
        while(true) {
            System.out.println("\n\tNEW GAME\tCreate a new game\n");
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