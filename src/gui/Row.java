package gui;

import javax.swing.*;

public class Row extends JPanel {

    BoxLayout rowLayout;

    Chessboard chessboard;

    public Row(Chessboard board, int column) {
        super();
        rowLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(rowLayout);

        chessboard = board;

        for(int i = 0; i < chessboard.getxLength(); i++) {
            Cell cell = new Cell(chessboard.getDigitalChessboard().get_Cell(i, column));
            add(cell);
        }
    }

}
