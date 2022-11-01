package org.example.example.piece;

import org.example.example.movement.MovementBehaviour;

public class Piece {
    private Color color;
    private MovementBehaviour movementBehaviour;
    private String type;
    private boolean dead;
    private boolean canPromote;

    public Piece(Color color, MovementBehaviour movementBehaviour, String type, boolean canPromote) {
        this.color = color;
        this.movementBehaviour = movementBehaviour;
        this.type = type;
        this.dead = false;
        this.canPromote = canPromote;
    }

    public Piece(Color color , Piece pieceToPromote){
        this.color = color;
        this.movementBehaviour = pieceToPromote.getMovementBehaviour();
        this.type = pieceToPromote.getType();
        this.dead = false;
        this.canPromote = false;
    }


    public Color getColor() {
        return color;
    }

    public MovementBehaviour getMovementBehaviour() {
        return movementBehaviour;
    }

    public String getType() {
        return type;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean getCanPromote(){
        return canPromote;
    }

    public void killPiece(){
        dead = true;
    }
}
