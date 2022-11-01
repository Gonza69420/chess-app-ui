package org.example.example;

import edu.austral.dissis.chess.gui.*;
import org.example.example.fabric.GameFabricator;
import org.example.example.game.*;
import org.example.example.movement.InfiniteMove;
import org.example.example.movement.MovementBehaviour;
import org.example.example.piece.Color;
import org.example.example.piece.Piece;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GameEngineClassic implements GameEngine {
    Game game;
    List<ChessPiece> pieces;
    PlayerColor playerColor;

    public GameEngineClassic(){
       this.game = GameFabricator.createClassicGame();
       pieces = updateChessPieceList();
    }

    public List<ChessPiece> updateChessPieceList(){
        List<ChessPiece> pieceChess = new ArrayList<>();
        List<Cordinate> cordinateWithPieces = this.game.getBoard().getAllCordinatesWithPieces();
        for (int i = 0; i < cordinateWithPieces.size() ; i++) {
            Piece piece = cordinateWithPieces.get(i).getPiece();
            pieceChess.add(new ChessPiece(Integer.toString(i), piece.getColor().equals(Color.WHITE) ? PlayerColor.WHITE : PlayerColor.BLACK, new Position(cordinateWithPieces.get(i).getX(), cordinateWithPieces.get(i).getY()),  piece.getType().toString()));
        }
        return pieceChess;
    }

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        game.makeAMove(move.component1().component1() , move.component1().component2() , move.component2().component1(), move.component2().component2());
        game.changeTurn();
        return new NewGameState(updateChessPieceList(), game.getTurn().equals(Color.WHITE) ? PlayerColor.WHITE : PlayerColor.BLACK);
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(new BoardSize(8, 8), pieces, PlayerColor.WHITE );
    }
}
