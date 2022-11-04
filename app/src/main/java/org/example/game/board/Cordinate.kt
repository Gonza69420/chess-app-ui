package org.example.game.board

import org.example.game.piece.Piece

interface Cordinate {

    fun pieceArrival(Piece : Piece) : CordinateWithPiece

    fun pieceDeparture() : EmptyCordinate

    fun hasPiece() : Boolean

}