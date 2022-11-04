package org.example.game.board

import org.example.game.piece.Piece

interface Cordinate {
    val piece : Piece?
    val x : Int
    val y : Int
    fun pieceArrival(Piece : Piece) : CordinateWithPiece

    fun pieceDeparture() : EmptyCordinate

    fun hasPiece() : Boolean

}