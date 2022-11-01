package org.example.example.Validator;

import org.example.example.game.Board;
import org.example.example.game.Cordinate;
import org.example.example.game.WinCondition;
import org.example.example.movement.SpecialMovement;
import org.example.example.piece.Color;
import org.example.example.piece.Piece;

import java.util.List;

public class SpecialMoveValidator implements Validator {
    @Override
    public boolean validate(int x1, int y1, int x2, int y2, Board board, Color color, WinCondition winCondition) {
        Piece piece = board.getCordinate(x1 , y1).getPiece();
        if(piece == null){
            return false;
        }
        List<SpecialMovement> moves = piece.getMovementBehaviour().getSpecialMove();

        if (x1 == x2 && y1 == y2){
            return false;
        }
        if(board.getCordinate(x2, y2).hasPiece()) {
            if (winCondition.getLastAlivePieceByColor(color) == board.getCordinate(x2, y2).getPiece()) return false;
        }
        for (SpecialMovement move : moves) {
            for (int i = 0; i <move.getCondition().length ; i++) {
                if (validateSpecialMove(move.getCondition()[i], board)){
                    break;
                }
            }
            if(move.getPlusX() == Math.abs(x2 - x1) && move.getPlusY() == Math.abs(y2 - y1)){
                if (move.canMoveThroughPieces()) {
                    return true;
                } else {
                    List<Cordinate> cordinates = board.getCordinatesBetween(x1, y1, x2, y2);
                    for (Cordinate cordinate : cordinates) {
                        if (cordinate.getPiece() != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validateSpecialMove(Cordinate condition, Board board){
        Piece piece = board.getCordinate(condition.getX() , condition.getY()).getPiece();
        if(piece == null){
            return false;
        }
        if (piece.getType().equals( condition.getPiece().getType())){
            return true;
        }
        return false;
    }

}
