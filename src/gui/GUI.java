package gui;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private JFrame window;

    private JScrollPane scrollChessboard;
    private JPanel chessboard;
    private BoxLayout chessboardLayout;

    //private JPanel[][] cells;

    board.Board digitalBoard;

    public GUI(board.Board board) {
        window = new JFrame();
        GroupLayout layout = new GroupLayout(window.getContentPane());
        chessboard = new JPanel();
        chessboardLayout = new BoxLayout(chessboard, BoxLayout.Y_AXIS);
        digitalBoard = board;
        //cells = new JPanel[digitalBoard.get_xLength()][digitalBoard.get_yLength()];
        scrollChessboard = new JScrollPane(chessboard, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        window.add(scrollChessboard);

        chessboard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chessboard.setLayout(chessboardLayout);
        for(int i = digitalBoard.get_yLength()-1; i >= 0; i--) {
            //Row row = new Row();
            for(int j = 0; j < digitalBoard.get_xLength(); j++) {
                Cell cell = new Cell(digitalBoard.get_Cell(i, j));
                //row.add(cell);
            }
            //chessboard.add(row);
        }

        window.setTitle("Chess");
        //window.setResizable(false);
        window.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addContainerGap()
                //.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(chessboard)
                )
                //.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addContainerGap()
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
            .addComponent(chessboard)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
        );

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.pack();
        window.setVisible(true);
    }

}
