package org.example.example.game;

public class GameStatus {
    private boolean playing;
    private Player Winnner;
    private boolean draw;

    public GameStatus() {
        this.playing = true;
        this.Winnner = null;
        this.draw = false;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setWinnner(Player winnner) {
        playing = false;
        Winnner = winnner;
    }

    public Player getWinnner() {
        return Winnner;
    }

    public boolean isDraw() {
        playing = false;
        draw = true;
        return draw;
    }


}
