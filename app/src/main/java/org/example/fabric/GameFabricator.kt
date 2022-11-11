package org.example.fabric

import org.example.game.AntiChessGame
import org.example.game.Game
import org.example.game.WinCondition
import org.example.game.piece.Color

class GameFabricator {

    fun createClassicGame() : Game{
        val pieceFabricator = PieceFabricator()
        val boardFabricator = BoardFabricator()
        val board = boardFabricator.createNormalBoard()
        val winCondition = WinCondition(listOf(pieceFabricator.createKing(5, Color.WHITE) , pieceFabricator.createKing(29 , Color.BLACK)))
        return Game(board, winCondition, Color.WHITE, pieceFabricator.createQueen(4, Color.WHITE))
    }

    fun createAntiChessGame() : AntiChessGame{
        val pieceFabricator = PieceFabricator()
        val boardFabricator = BoardFabricator()
        val board = boardFabricator.createAntiChessBoard()
        val winCondition = WinCondition(listOf())
        return AntiChessGame(board, winCondition, Color.WHITE, pieceFabricator.createQueen(4, Color.WHITE))
    }
}