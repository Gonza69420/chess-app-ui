package org.example.game.board

import org.example.game.piece.EmptyPiece
import org.example.game.piece.Piece

class Cordinate(
    val piece : Piece = EmptyPiece(),
    val x : Int,
    val y : Int
) {
    fun pieceArrival(Piece : Piece) : Cordinate {
        return Cordinate(Piece, x, y)
    }

    fun pieceDeparture() : Cordinate {
        return Cordinate(x = x, y = y)
    }

}