package org.example.example.Validator;

import org.example.example.game.Board;
import org.example.example.game.Cordinate;
import org.example.example.game.WinCondition;
import org.example.example.piece.Color;

import java.util.List;

public class StaleMateValidator implements Validator {
    @Override
    public boolean validate(int x1, int y1, int x2, int y2, Board board, Color color, WinCondition winCondition) {
        List<Cordinate> alivePieces = board.getFriendlyPiecesCordinates(color);
        return false;
    }

}
