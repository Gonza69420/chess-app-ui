package org.example.example.fabric;

import org.example.example.game.Cordinate;
import org.example.example.movement.InfiniteMove;
import org.example.example.movement.MovementBehaviour;
import org.example.example.movement.NormalMove;
import org.example.example.movement.SpecialMovement;
import org.example.example.piece.Color;
import org.example.example.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class PieceFabricator {

    public static Piece createPawn(Color color, Cordinate[] cordinate) {
        List<NormalMove> normalMoves = new ArrayList<>();
        List<SpecialMovement> specialMovements = new ArrayList<>();
        List<InfiniteMove> infiniteMoves = new ArrayList<>();
        if (color.equals(Color.WHITE)){
            normalMoves.add(new NormalMove(0,1, false));
            specialMovements.add(new SpecialMovement(0,2, false, cordinate));
        } else {
            normalMoves.add(new NormalMove(0,-1, false));
            specialMovements.add(new SpecialMovement(0,-2, false, cordinate));
        }
        return new Piece(color, new MovementBehaviour(normalMoves, specialMovements, infiniteMoves), "pawn", true);
    }

    public static Piece createKnight(Color color){
        List<NormalMove> normalMoves = new ArrayList<>();
        List<SpecialMovement> specialMovements = new ArrayList<>();
        List<InfiniteMove> infiniteMoves = new ArrayList<>();
        normalMoves.add(new NormalMove(1,2, true));
        normalMoves.add(new NormalMove(2,1, true));
        normalMoves.add(new NormalMove(2,-1, true));
        normalMoves.add(new NormalMove(1,-2, true));
        normalMoves.add(new NormalMove(-1,-2, true));
        normalMoves.add(new NormalMove(-2,-1, true));
        normalMoves.add(new NormalMove(-2,1, true));
        normalMoves.add(new NormalMove(-1,2, true));
        return new Piece(color, new MovementBehaviour(normalMoves, specialMovements, infiniteMoves), "knight", false);
    }

    public static Piece createRook(Color color){
        List<NormalMove> normalMoves = new ArrayList<>();
        List<SpecialMovement> specialMovements = new ArrayList<>();
        List<InfiniteMove> infiniteMoves = new ArrayList<>();
        infiniteMoves.add(new InfiniteMove(1,0));
        infiniteMoves.add(new InfiniteMove(-1,0));
        infiniteMoves.add(new InfiniteMove(0,1));
        infiniteMoves.add(new InfiniteMove(0,-1));
        return new Piece(color, new MovementBehaviour(normalMoves, specialMovements, infiniteMoves), "rook", false);
    }

    public static Piece createBishop(Color color){
        List<NormalMove> normalMoves = new ArrayList<>();
        List<SpecialMovement> specialMovements = new ArrayList<>();
        List<InfiniteMove> infiniteMoves = new ArrayList<>();
        infiniteMoves.add(new InfiniteMove(1,1));
        infiniteMoves.add(new InfiniteMove(-1,-1));
        infiniteMoves.add(new InfiniteMove(1,-1));
        infiniteMoves.add(new InfiniteMove(-1,1));
        return new Piece(color, new MovementBehaviour(normalMoves, specialMovements, infiniteMoves), "bishop", false);
    }

    public static Piece createQueen(Color color){
        List<NormalMove> normalMoves = new ArrayList<>();
        List<SpecialMovement> specialMovements = new ArrayList<>();
        List<InfiniteMove> infiniteMoves = new ArrayList<>();
        infiniteMoves.add(new InfiniteMove(1,0));
        infiniteMoves.add(new InfiniteMove(-1,0));
        infiniteMoves.add(new InfiniteMove(0,1));
        infiniteMoves.add(new InfiniteMove(0,-1));
        infiniteMoves.add(new InfiniteMove(1,1));
        infiniteMoves.add(new InfiniteMove(-1,-1));
        return new Piece(color, new MovementBehaviour(normalMoves, specialMovements, infiniteMoves), "queen", false);
    }

    public static Piece createKing(Color color, Cordinate[] cordinate){
        List<NormalMove> normalMoves = new ArrayList<>();
        List<SpecialMovement> specialMovements = new ArrayList<>();
        List<InfiniteMove> infiniteMoves = new ArrayList<>();
        normalMoves.add(new NormalMove(1,0, true));
        normalMoves.add(new NormalMove(-1,0, true));
        normalMoves.add(new NormalMove(0,1, true));
        normalMoves.add(new NormalMove(0,-1, true));
        normalMoves.add(new NormalMove(1,1, true));
        normalMoves.add(new NormalMove(-1,-1, true));
        specialMovements.add(new SpecialMovement(2,0, true, cordinate));
        specialMovements.add(new SpecialMovement(-2,0, true, cordinate));
        return new Piece(color, new MovementBehaviour(normalMoves, specialMovements, infiniteMoves), "king", false);
    }
}
