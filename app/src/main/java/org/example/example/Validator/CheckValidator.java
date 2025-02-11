package org.example.example.Validator;

import org.example.example.game.Board;
import org.example.example.game.Cordinate;
import org.example.example.game.WinCondition;
import org.example.example.piece.Color;
import org.example.example.piece.Piece;


import java.util.List;

public class CheckValidator implements Validator {
    private List<Validator> validators;

    public CheckValidator(List<Validator> validators) {
        this.validators = validators;
    }

    @Override
    public boolean validate(int x1, int y1, int x2, int y2, Board board, Color color, WinCondition winCondition) {
        int alivePieces = winCondition.getPieces().size();
        Piece onlyAlivePiece = null;
        for (int i = 0; i < winCondition.getPieces().size() ; i++) {
            if (winCondition.getPieces().get(i).isDead()){
                alivePieces--;
            }
            if (alivePieces != 1) {
                return false;
            }else if (i == winCondition.getPieces().size() - 1){
                onlyAlivePiece = winCondition.getPieces().get(i);
            }
        }
        Cordinate cordinate = board.getPieceCordinate(onlyAlivePiece, color);
        if ( cordinate != null){
            for(Cordinate cordinateOfPieces : board.getEnemyPiecesCordinates(color)){
                for (Validator validator : validators) {
                    if (validator.validate(cordinateOfPieces.getX(), cordinateOfPieces.getY(), cordinate.getX(), cordinate.getY(), board, color, winCondition)){
                        return true;
                    }
                }
            }
        }else{
            return false;
        }
        return false;
    }


}
