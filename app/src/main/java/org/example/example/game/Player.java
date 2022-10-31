package org.example.example.game;


import org.example.example.piece.Color;

public class Player {
    private Color color;
    private String name;
    private Game game;

    public Player(Color color, String name) {
        this.color = color;
        this.name = name;
        this.game = null;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void createGame(Game game) {
        this.game = game;
    }

    public void invitePlayer(Player player){
        //Todo
    }

    public void makeAMove(int x1 , int y1 , int x2 , int y2){
        //TODO
    }
}
