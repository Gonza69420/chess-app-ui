package org.example.example.Validator;

import org.example.example.game.Board;
import org.example.example.game.WinCondition;
import org.example.example.piece.Color;

public interface Validator {
    boolean validate(int x1 , int y1 , int x2 , int y2, Board board, Color color, WinCondition winCondition);
}
