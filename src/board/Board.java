package board;

/**
 * @author Alejandro Doberenz
 * @version 4/27/2019
 */
public class Board implements Cloneable {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private int xLength, yLength;

    private Cell[][] cellArray;
    // </editor-fold>

    public Board(int x, int y) {
        xLength = x;
        yLength = y;
        cellArray = new Cell[yLength][xLength];
        for(int i = 0; i < yLength; i++) {
            for(int j = 0; j < xLength; j++)
                new Cell(this, j, i);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Accessor and Mutator Methods">
    public int getX()                       { return xLength; }

    public int getY()                       { return yLength; }

    public Cell[][] getCellArray()         { return cellArray; }

    public Cell getCell(int x, int y)       { return cellArray[y][x]; }

    void setCell(Cell cell, int x, int y)   { cellArray[y][x] = cell; }
    // </editor-fold>

    public void consoleDraw(boolean whiteBottom) {
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
                    if(cell.getIsOccupied()) System.out.print(cell.getOccupant().getClass().getSimpleName().charAt(0) + "  ");
                    else System.out.print("O  ");
                }
                System.out.println("|");
            }
        } else {
            for(int y = 0; y < yLength; y++) {
                System.out.print("|  ");
                for(int x = xLength-1; x >= 0; x--) {
                    Cell cell = getCell(x, y);
                    if(cell.getIsOccupied()) System.out.print(cell.getOccupant().getClass().getSimpleName().charAt(0) + "  ");
                    else System.out.print("O  ");
                }
                System.out.println("|");
            }
        }

        // Draw the bottom of the border
        for(int x = 0; x < xLength*3+4; x++)
            System.out.print("-");
        System.out.println();
    }

    public void consoleDrawWhite(boolean whiteBottom) {
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
                    if(cell.getIsOccupied() && cell.getOccupant().getColor().equals(java.awt.Color.WHITE)) System.out.print(cell.getOccupant().getClass().getSimpleName().charAt(0) + "  ");
                    else System.out.print("O  ");
                }
                System.out.println("|");
            }
        } else {
            for(int y = 0; y < yLength; y++) {
                System.out.print("|  ");
                for(int x = xLength-1; x >= 0; x--) {
                    Cell cell = getCell(x, y);
                    if(cell.getIsOccupied() && cell.getOccupant().getColor().equals(java.awt.Color.WHITE)) System.out.print(cell.getOccupant().getClass().getSimpleName().charAt(0) + "  ");
                    else System.out.print("O  ");
                }
                System.out.println("|");
            }
        }

        // Draw the bottom of the border
        for(int x = 0; x < xLength*3+4; x++)
            System.out.print("-");
        System.out.println();
    }

    public void consoleDrawBlack(boolean whiteBottom) {
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
                    if(cell.getIsOccupied() && cell.getOccupant().getColor().equals(java.awt.Color.BLACK)) System.out.print(cell.getOccupant().getClass().getSimpleName().charAt(0) + "  ");
                    else System.out.print("O  ");
                }
                System.out.println("|");
            }
        } else {
            for(int y = 0; y < yLength; y++) {
                System.out.print("|  ");
                for(int x = xLength-1; x >= 0; x--) {
                    Cell cell = getCell(x, y);
                    if(cell.getIsOccupied() && cell.getOccupant().getColor().equals(java.awt.Color.BLACK)) System.out.print(cell.getOccupant().getClass().getSimpleName().charAt(0) + "  ");
                    else System.out.print("O  ");
                }
                System.out.println("|");
            }
        }

        // Draw the bottom of the border
        for(int x = 0; x < xLength*3+4; x++)
            System.out.print("-");
        System.out.println();
    }

}
