package org.example.example.game;

import org.example.example.piece.Color;
import org.example.example.piece.Piece;


import java.util.ArrayList;
import java.util.List;

public class WinCondition {
    private List<Piece> pieces;

    public WinCondition(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public List<Piece> getPiecesByColor(Color color){
        List<Piece> piecesColor = new ArrayList<>();
        for (int i = 0; i <pieces.size() ; i++) {
            if (pieces.get(i).getColor().equals(color)){
                piecesColor.add(pieces.get(i));
            }
        }
        return piecesColor;
    }

    public Piece getLastAlivePieceByColor(Color color ){
        List<Piece> piecesColor = getPiecesByColor(color);
        for (int i = 0; i <piecesColor.size() ; i++) {
            if (!piecesColor.get(i).isDead()){
                return piecesColor.get(i);
            }
        }
        return null;
    }

    public boolean isOnly1PieceAliveByColor(Color color){
        List<Piece> piecesColor = getPiecesByColor(color);
        int alivePieces = 0;
        for (int i = 0; i <piecesColor.size() ; i++) {
            if (!piecesColor.get(i).isDead()){
                alivePieces++;
            }
        }
        return alivePieces == 1;
    }
}
