package gui;

import javax.swing.*;

public class Window extends javax.swing.JFrame {

    private GroupLayout layout;

    private game.Game class_game;

    private Chessboard board;

    public Window(game.Game game) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        layout = new GroupLayout(this.getContentPane());
        getContentPane().setLayout(layout);

        class_game = game;

        board = new Chessboard(class_game.getBoard());

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(board)
                .addContainerGap()
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(board)
                .addContainerGap()
        );

        pack();
    }

}
