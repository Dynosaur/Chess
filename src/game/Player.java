package game;

import java.awt.Color;

public class Player {

    public String name;

    private Game game;

    @Override public String toString() {
        return name;
    }

    public Player(Game g, String n) {
        game = g;
        name = n;
        if(game.getVerbose())
            System.out.println("> New Player " + this + " created.");
    }

}