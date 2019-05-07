import game.layout.PieceLayout;
import game.type.GameType;
import game.type.NineHorses;
import game.type.StandardChess;
import game.Game;

import java.awt.Color;
import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class ChessRunner {

    private static GameType gameType;
    private static PieceLayout gameLayout;
    private static boolean gameVerbosity, gameSingleplayer;
    private static Color gamePlayerColor = Color.WHITE;
    private static StandardChess standard = new StandardChess();
    private static NineHorses nineHorses = new NineHorses();
    private static GameType[] gameTypes = {standard, nineHorses};

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
        System.out.println("-------------------------------------------------------" +
        "\n\tBACK\tGoes back an input loop\n\tEXIT\tExits the program\n" +
        "\n\tLowercase options indicate it cannot be edited.\n" +
        "-------------------------------------------------------");
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
    private static void verbose() {
        verboseLoop: while(true) {
            System.out.println("\n\t\tVERBOSE OPTIONS\n" +
            "\tON\tTurn verbose mode on, printing additional information in the console.\n" +
            "\tOFF\tTurn verbose mode off.\n");
            String input = getStringInput();
            switch(input.toLowerCase().trim()) {
                case "back":
                    break verboseLoop;
                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "help":
                    help();
                    break;
                case "on":
                    gameVerbosity = true;
                    break verboseLoop;
                case "off":
                    gameVerbosity = false;
                    break verboseLoop;
                default:
                    System.out.println("\'" + input + "\' is not an available option.");
                    break;
            }
        }
    }
    private static void gameType() {
        gameTypeLoop: while(true) {
            System.out.println("\n\t\tGAME TYPE");
            for (GameType gt : gameTypes)
                System.out.println("\t" + gt.name + "\t\t" + gt.description);
            System.out.println();
            String input = getStringInput();
            switch (input.toLowerCase().trim()) {
                case "back":
                    break gameTypeLoop;
                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "help":
                    help();
                    break;
                default:
                    for (GameType gt : gameTypes) {
                        if (input.toLowerCase().trim().equals(gt.name.toLowerCase())) {
                            gameType = gt;
                            gameLayout = gameType.getPieceLayout();
                            break gameTypeLoop;
                        }
                    }
                    System.out.println("\'" + input + "\' is not an available option.");
                    break;
            }
        }
    }
    private static void mode() {
        modeLoop: while(true) {
            System.out.println("\n\t\tMODE OPTIONS\n" +
                    "\tSINGLEPLAYER\tPlay against the computer.\n" +
                    "\tMULTIPLAYER\t\tPlay locally against an opponent.\n");
            String input = getStringInput();
            switch(input.toLowerCase().trim()) {
                case "back":
                    break modeLoop;
                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "help":
                    help();
                    break;
                case "singleplayer":
                    gameSingleplayer = true;
                    break modeLoop;
                case "multiplayer":
                    gameSingleplayer = false;
                    break modeLoop;
                default:
                    System.out.println("\'" + input + "\' is not an available option.");
                    break;
            }
        }
    }
    private static void color() {
        colorLoop: while(true) {
            System.out.println("\n\t\tCOLOR OPTIONS\n" +
            "\tWHITE\tBe the White player.\n" +
            "\tBLACK\tBe the Black player.\n");
            String input = getStringInput();
            switch(input.toLowerCase().trim()) {
                case "back":
                    break colorLoop;
                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "help":
                    help();
                    break;
                case "white":
                    gamePlayerColor = Color.WHITE;
                    break colorLoop;
                case "black":
                    gamePlayerColor = Color.BLACK;
                    break colorLoop;
                default:
                    System.out.println("\'" + input + "\' is not an available option.");
                    break;
            }
        }
    }
    private static void newGame() {
        gameType = standard;
        gameLayout = gameType.getPieceLayout();
        gameVerbosity = false;
        gameSingleplayer = true;
        newGameLoop: while(true) {
            System.out.println("\n\t\tOPTIONS\n" +
            "\tGAME TYPE\t" + gameType.name + "\n" +
            "\tMODE\t\t" + ((gameSingleplayer) ? "Singleplayer" : "Multiplayer") + "\n" +
            "\tCOLOR\t\t" + (gamePlayerColor.equals(Color.WHITE) ? "White" : "Black") + "\n" +
            "\tVERBOSE\t\t" + ((gameVerbosity) ? "On" : "Off") + "\n" +
            //"\tLayout\t\t" + gameLayout.name + "\n" +
            "\tBoard Size\t" + gameType.getXSize() + "x" + gameType.getYSize() + "\n" +
            "\n\tSTART\tStart the game.");
            String input = getStringInput();
            switch(input.toLowerCase().trim()) {
                case "back":
                    break newGameLoop;
                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "game type":
                    gameType();
                    break;
                case "mode":
                    mode();
                    break;
                case "color":
                    color();
                    break;
                case "verbose":
                    verbose();
                    break;
                case "layout":
                    System.out.println("Layout cannot be edited.");
                    break;
                case "board size":
                    System.out.println("Board size cannot be edited.");
                    break;
                case "help":
                    help();
                    break;
                case "start":
                    //Game game = new Game(gameVerbosity, gameType);
                    //game.run();
                    break newGameLoop;
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
            switch(input.toLowerCase().trim()) {
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
        //run();
        Game game = new Game(new StandardChess());
        Thread gameThread = new Thread(game);
        gameThread.start();
    }

}