package test;

import javax.swing.*;

public class Pawn {

    private static ImageIcon image;

    public ImageIcon getImage() {
        return image;
    }

    public Pawn() {
        image = new ImageIcon(getClass().getResource("images/image2.jpg"));
        image = new ImageIcon(image.getImage().getScaledInstance(100, 100, 0));
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        Pawn pawn1 = new Pawn();

        JLabel label1 = new JLabel();
        label1.setIcon(pawn1.getImage());
        window.add(label1);
        window.pack();
    }

}
