package org.example.game.board

import org.example.game.piece.Piece

class CordinateWithPiece(
    val piece : Piece,
    val x : Int,
    val y : Int
) : Cordinate {

    override fun pieceArrival(Piece: Piece): CordinateWithPiece {
        TODO("Not yet implemented")
    }

    override fun pieceDeparture(): EmptyCordinate {
        TODO("Not yet implemented")
    }

    override fun hasPiece(): Boolean {
        TODO("Not yet implemented")
    }
}
}