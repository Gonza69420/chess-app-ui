package org.example.example.fabric;

import org.example.example.game.Board;
import org.example.example.game.Game;
import org.example.example.game.Player;
import org.example.example.game.WinCondition;
import org.example.example.piece.Color;
import org.example.example.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class GameFabricator {

    public static Game createClassicGame(){
        Board board = BoardFabricator.createNormalBoard();
        List<Piece> winConditionPieces = new ArrayList<>();
        winConditionPieces.add(board.getCordinate(1,5).getPiece());
        winConditionPieces.add(board.getCordinate(8,5).getPiece());
        WinCondition winCondition = new WinCondition(winConditionPieces);
        Player player1 = new Player(Color.WHITE, "white");
        Player player2 = new Player(Color.BLACK, "black");
        return new Game(player1 , player2, board, winCondition, board.getCordinate(1,4).getPiece());
    }
}
