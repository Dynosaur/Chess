package game;

import java.awt.Color;

public class Player {

    public String name;

    public Color color;

    private Game game;

    @Override public String toString() {
        return name;
    }

    public Player(Game g, String n, Color c) {
        game = g;
        name = n;
        color = c;
        if(game.getVerbose())
            System.out.println("> New Player " + this + " created.");
    }

}