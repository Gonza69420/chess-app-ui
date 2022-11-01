package org.example.example;



import org.example.example.Validator.InfiniteMoveValidator;
import org.example.example.Validator.NormalValidator;
import org.example.example.game.Board;
import org.example.example.game.Cordinate;
import org.example.example.movement.InfiniteMove;
import org.example.example.movement.MovementBehaviour;
import org.example.example.movement.NormalMove;
import org.example.example.piece.Color;
import org.example.example.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cordinate> cordinates = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cordinates.add(new Cordinate(i, j));
            }
        }
        Board board = new Board(cordinates);
        List<NormalMove> moves = new ArrayList<>();
        moves.add(new NormalMove(2, 2, true));
        moves.add(new NormalMove(1, 2, true));
        MovementBehaviour movementBehaviour = new MovementBehaviour(moves , List.of() , List.of());
        Piece piece = new Piece(Color.BLACK ,movementBehaviour , "King", false);
        board.getCordinate(0, 0).pieceArrival(piece);
        NormalValidator normalValidator = new NormalValidator();
        Piece piece2 = new Piece(Color.BLACK ,movementBehaviour , "Pawn", true);
        board.getCordinate(1, 1).pieceArrival(piece2);

        
        List<InfiniteMove> infiniteMoves = new ArrayList<>();
        infiniteMoves.add(new InfiniteMove(1, 1));
        MovementBehaviour movementBehaviour2 = new MovementBehaviour(moves , List.of() , infiniteMoves);
        Piece piece3 = new Piece(Color.WHITE ,movementBehaviour2 , "Master", false);
        board.getCordinate(3,3).pieceArrival(piece3);
        InfiniteMoveValidator infiniteMove = new InfiniteMoveValidator();

        Piece piece43 = new Piece(Color.BLACK ,movementBehaviour , "King", false);
        Piece piece44 = new Piece(Color.BLACK ,movementBehaviour , "King", false);


        for (int i = 0; i <moves.size() ; i++) {
            System.out.println(moves.get(i).canMoveThroughPieces());
        }
    }
}