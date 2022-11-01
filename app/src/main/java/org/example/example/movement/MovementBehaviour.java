package org.example.example.movement;

import java.util.ArrayList;
import java.util.List;

public class MovementBehaviour {
    private List<NormalMove> moves;
    private List<SpecialMovement> specialMove;
    private List<InfiniteMove> infiniteMoves;

    public MovementBehaviour(List<NormalMove> moves, List<SpecialMovement> specialMove, List<InfiniteMove> infiniteMoves) {
        this.moves = moves;
        this.specialMove = specialMove;
        this.infiniteMoves = infiniteMoves;
    }

    public List<NormalMove> getMoves() {
        return moves;
    }

    public List<SpecialMovement> getSpecialMove() {
        return specialMove;
    }

    public List<InfiniteMove> getInfiniteMoves() {
        return infiniteMoves;
    }


}
