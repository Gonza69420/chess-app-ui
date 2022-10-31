package org.example.example.Validator;

import org.example.example.game.Board;
import org.example.example.game.Cordinate;
import org.example.example.game.WinCondition;
import org.example.example.movement.NormalMove;
import org.example.example.piece.Color;
import org.example.example.piece.Piece;

import java.util.List;

public class NormalValidator implements Validator {
    @Override
    public boolean validate(int x1, int y1, int x2, int y2, Board board, Color color, WinCondition winCondition) {
        Piece piece = board.getCordinate(x1, y1).getPiece();
        if (piece == null) {
            return false;
        }
        if (board.getCordinate(x2, y2).getPiece() != null) {
            if (board.getCordinate(x2, y2).getPiece().getColor() == color) {
                return false;
            }
        }
        if (x1 == x2 && y1 == y2) {
            return false;
        }
        if (board.getCordinate(x2, y2).hasPiece()) {
            if (winCondition.getLastAlivePieceByColor(color) == board.getCordinate(x2, y2).getPiece()) return false;
        }

        List<NormalMove> moves = piece.getMovementBehaviour().getMoves();
        for (NormalMove move : moves) {
            if (move.getPlusX() == Math.abs(x2 - x1) && move.getPlusY() == Math.abs(y2 - y1)) {
                if (move.canMoveThroughPieces()) {
                    return true;
                }
                List<Cordinate> cordinates = board.getCordinatesBetween(x1, y1, x2, y2);
                for (Cordinate cordinate : cordinates) {
                    if (cordinate.getPiece() != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

