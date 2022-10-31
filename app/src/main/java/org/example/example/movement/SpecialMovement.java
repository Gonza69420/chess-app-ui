package org.example.example.movement;

import org.example.example.game.Cordinate;

public class SpecialMovement extends Move{
    private Cordinate[] condition;

    public SpecialMovement(int plusX, int plusY, boolean canMoveThroughPieces, Cordinate[] condition) {
        super(plusX, plusY, canMoveThroughPieces);
        this.condition = condition;
    }

    public Cordinate[] getCondition() {
        return condition;
    }
}
