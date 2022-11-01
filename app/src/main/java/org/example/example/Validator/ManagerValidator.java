package org.example.example.Validator;

import org.example.example.game.Board;
import org.example.example.game.WinCondition;
import org.example.example.piece.Color;
import org.example.example.piece.Piece;


import java.util.List;

public class ManagerValidator {
    CheckMateValidator checkMateValidator;
    CheckValidator checkValidator;
    InfiniteMoveValidator infiniteMoveValidator;
    NormalValidator normalValidator;
    SpecialMoveValidator specialMoveValidator;
    WinCondition winCondition;
    PromoteValidator promoteValidator;

    public boolean validMove(int x1  , int y1 , int x2, int y2, Board board , Color color) {
        boolean canMoveToPosition = false;
        if (checkMateValidator.validate(x1, y1, x2, y2, board, color, winCondition)) {
            return false;
        }
        if (!board.getCordinate(x1 , y1).hasPiece()){
            return false;
        }

        Piece piece = board.getCordinate(x1, y1).getPiece();

        if(piece.getColor() != color){
            return false;
        }
        if (!piece.getMovementBehaviour().getInfiniteMoves().isEmpty()) {
            if (infiniteMoveValidator.validate(x1, y1, x2, y2, board, color, winCondition)) {
                canMoveToPosition = true;
            }
        }
        if (!piece.getMovementBehaviour().getSpecialMove().isEmpty()) {
            if (specialMoveValidator.validate(x1, y1, x2, y2, board, color, winCondition)) {
                canMoveToPosition = true;
            }
        }
        if (!piece.getMovementBehaviour().getMoves().isEmpty()) {
            if (normalValidator.validate(x1, y1, x2, y2, board, color, winCondition)) {
                canMoveToPosition = true;
            }
        }

        if (canMoveToPosition) {
            if (checkValidator.validate(x1, y1, x2, y2, board, color, winCondition)) {
                Board boardCopy = board;
                boardCopy.getCordinate(x2, y2).pieceArrival(boardCopy.getCordinate(x1, y1).getPiece());
                if (checkValidator.validate(x2, y2, x1, x1, boardCopy, color, winCondition)) {
                    return false;
                }else{
                    return true;
                }
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public ManagerValidator(WinCondition winCondition) {
        this.infiniteMoveValidator = new InfiniteMoveValidator();
        this.normalValidator = new NormalValidator();
        this.specialMoveValidator = new SpecialMoveValidator();
        this.winCondition = winCondition;
        this.promoteValidator = new PromoteValidator();
        List<Validator> validators = List.of(infiniteMoveValidator, normalValidator, specialMoveValidator);
        this.checkValidator = new CheckValidator(validators);
        this.checkMateValidator = new CheckMateValidator(validators);
    }

    public boolean validPromotion (int x1  , int y1 , int x2, int y2, Board board , Color color){
        return promoteValidator.validate(x1, y1, x2, y2, board, color, winCondition);
    }

    public boolean isItCheckMate(Board board , Color color){
        return checkMateValidator.validate(0, 0, 0, 0, board, color, winCondition);
    }


    }

