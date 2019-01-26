package gui;

import javax.swing.*;

public class Cell extends JPanel {

    private board.Cell digitalCell;

    private JLabel label;

    public Cell(board.Cell cell) {
        super();
        digitalCell = cell;
        label = new JLabel();
        //label.setText(digitalCell.toString());
        label.setIcon(
            (digitalCell.get_Occupant() != null) ? digitalCell.get_Occupant().getImage() : null
        );
        add(label);
        setToolTipText(digitalCell.toString());
        setPreferredSize(new java.awt.Dimension(100, 100));
        setBackground(digitalCell.get_Color());
        System.out.println(getLayout());
    }

}
