package game;

import java.awt.Color;

public class Player {

    public String class_name;

    public Color class_color;

    private Game game;

    public Game get_game() {
        return game;
    }

    @Override public String toString() {
        return class_name;
    }

    public Player(Game g, String name, Color color) {
        game = g;
        class_name = name;
        class_color = color;
        if(game.get_verbose())
            System.out.println("> New Player " + this + " created.");
    }

}
