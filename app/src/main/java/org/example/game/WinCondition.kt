package org.example.game

import org.example.game.board.Board
import org.example.game.piece.Color
import org.example.game.piece.Piece

class WinCondition( val pieces : List<Piece>) {

    fun getIdOfWinConditionPieceAliveByColor (color : Color, board : Board) : List<Int> {
        var idOfPieces : List<Int> = ArrayList()
        if (pieces.size == 0){
            idOfPieces += -1
        }
        for (i in pieces) {
            if (i.getColor() == color) {
                if (board.getIdOfPiecesInBoard().contains(i.id)) {
                    idOfPieces += i.id
                }
            }
        }
        return idOfPieces
    }
}