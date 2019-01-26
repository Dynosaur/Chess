package board;

/**
 * 1/25/2019
 * @author Alejandro Doberenz
 * @version 0.21
 *
 * A Board represents the class_board a game of chess is played on. A class_board has an X and Y length (Measured in cellArray), and a
 * 2D array of every cell that makes it up.
 */
public class Board {

    private int xLength, yLength;   // The number of Cells along the X and Y axis.

    private Cell[][] cellArray;     // A 2D representation of the class_board. (Y, X)

    // <editor-fold defaultstate="collapsed" desc="Accessor Methods">

    public int get_xLength() {
        return xLength;
    }

    public int get_yLength() {
        return yLength;
    }

    public Cell get_Cell(int x, int y) {
        return cellArray[y][x];
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mutator Methods">

    void set_Cell(Cell cell, int x, int y) {
        cellArray[y][x] = cell;
    }

    // </editor-fold>

    public void consoleDraw() {
        for(int y = yLength-1; y >= 0; y--) {
            for(int x = 0; x < xLength; x++) {
                Cell cell = get_Cell(x, y);
                if(cell.get_Occupied())
                    System.out.print(cell.get_Occupant().toString().toUpperCase().charAt(0) + "  ");
                else
                    System.out.print("O  ");
            }
            System.out.println();
        }
    }

    public Board(int x, int y) {
        xLength     = x;
        yLength     = y;
        cellArray   = new Cell[yLength][xLength];   // Due to how 2D arrays are made in Java, it must be made
                                                    // in (Y, X) fashion rather than (X, Y)
        for(int i = 0; i < yLength; i++) {
            for(int j = 0; j < xLength; j++) {
                java.awt.Color color = (((j + i) % 2) == 0) ? new java.awt.Color(0, 0, 0) : new java.awt.Color(255, 255, 255);
                new Cell(this, j, i, color);
            }
        }
    }

}
