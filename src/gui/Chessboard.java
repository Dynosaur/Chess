package gui;

import javax.swing.*;

import board.Board;

public class Chessboard extends JPanel {

    private BoxLayout layout;

    private Board digitalChessboard;

    private int xLength, yLength;

    public Board getDigitalChessboard() {
        return digitalChessboard;
    }
    public int getxLength() {
        return xLength;
    }
    public int getyLength() {
        return yLength;
    }

    public Chessboard(board.Board board) {
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 3, true));

        digitalChessboard = board;
        xLength = digitalChessboard.get_xLength();
        yLength = digitalChessboard.get_yLength();

        for(int i = yLength-1; i >= 0; i--) {
            Row row = new Row(this, i);
            add(row);
        }
    }

}
