package org.example.example.movement;

public class Move {
    private int plusX;
    private int plusY;
    private boolean canMoveThroughPieces;

    public Move(int plusX, int plusY, boolean canMoveThroughPieces) {
        this.plusX = plusX;
        this.plusY = plusY;
        this.canMoveThroughPieces = canMoveThroughPieces;
    }

    public int getPlusX() {
        return plusX;
    }

    public int getPlusY() {
        return plusY;
    }

    public boolean canMoveThroughPieces() {
        return canMoveThroughPieces;
    }

}
