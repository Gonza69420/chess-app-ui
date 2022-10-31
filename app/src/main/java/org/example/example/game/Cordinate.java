package org.example.example.game;

import org.example.example.piece.Piece;

public class Cordinate {
    private Piece piece;
    private int x;
    private int y;
    private boolean hasPiece;

    public Cordinate(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.hasPiece = true;
    }

    public Cordinate(int x , int y ){
        this.x = x;
        this.y = y;
        this.hasPiece = false;
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void pieceArrival(Piece piece) {
        this.piece = piece;
        hasPiece = true;
    }

    public void pieceDeparture() {
        this.piece = null;
        hasPiece = false;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean hasPiece() {
        return hasPiece;
    }



}
