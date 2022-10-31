package org.example.example.game;

import org.example.example.piece.Color;

public class History {
    private Cordinate from;
    private Cordinate to;
    private Color color;

    public History(Cordinate from, Cordinate to, Color color) {
        this.from = from;
        this.to = to;
        this.color = color;
    }

    public Cordinate getFrom() {
        return from;
    }

    public Cordinate getTo() {
        return to;
    }

    public Color getColor() {
        return color;
    }


}
