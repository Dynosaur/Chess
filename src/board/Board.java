package board;

import game.Game;

/**
 * @author Alejandro Doberenz
 * @version 3/26/2019
 *
 * A Board represents the board a game of chess is played on. A board has an X and Y length (Measured in cellArray), and a
 * 2D array of every cell that makes it up.
 */
public class Board {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private int xLength, yLength;   // The number of Cells along the X and Y axis.

    private Cell[][] cellArray;     // A 2D representation of the board. (Y, X)

    private Game game;
    // </editor-fold>

    public void consoleDraw(boolean whiteBottom) {
        if(game.getVerbose())
            System.out.println("\t> Drawing board...\tWhite is bottom: " + whiteBottom);
        // Draw the top of the border
        for(int x = 0; x < xLength*3+4; x++)
            System.out.print("-");
        System.out.println();

        // Draw each row
        if(whiteBottom) {
            for(int y = yLength - 1; y >= 0; y--) {
                System.out.print("|  ");
                for(int x = 0; x < xLength; x++) {
                    Cell cell = getCell(x, y);
                    if(cell.getIsOccupied())
                        System.out.print(cell.getOccupant().toString().toUpperCase().charAt(1) + "  ");
                    else
                        System.out.print("O  ");
                }
                System.out.println("|");
            }
        } else {
            for(int y = 0; y < yLength; y++) {
                System.out.print("|  ");
                for(int x = xLength-1; x >= 0; x--) {
                    Cell cell = getCell(x, y);
                    if(cell.getIsOccupied())
                        System.out.print(cell.getOccupant().toString().toUpperCase().charAt(1) + "  ");
                    else
                        System.out.print("O  ");
                }
                System.out.println("|");
            }
        }

        // Draw the bottom of the border
        for(int x = 0; x < xLength*3+4; x++)
            System.out.print("-");
        System.out.println();
    }

    public Board(Game g, int x, int y) {
        xLength = x;
        yLength = y;
        game = g;                                   // in (Y, X) fashion rather than (X, Y)
        cellArray = new Cell[yLength][xLength];     // Due to how 2D arrays are made in Java, it must be made
        for(int i = 0; i < yLength; i++) {
            for(int j = 0; j < xLength; j++)
                new Cell(this, j, i);
        }
        if(game.getVerbose())
            System.out.println("\t> New board successfully created.");
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getX()                       { return xLength; }

    public int getY()                       { return yLength; }

    public Cell[][] get_CellArray()         { return cellArray; }

    public Cell getCell(int x, int y)       { return cellArray[y][x]; }

    public Game getGame()                   { return game; }

    void set_Cell(Cell cell, int x, int y)  { cellArray[y][x] = cell; }
    // </editor-fold>

}