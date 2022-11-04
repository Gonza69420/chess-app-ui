package org.example.game.board

import org.example.game.piece.Piece

class EmptyCordinate(override val x: Int, override val y: Int, override val piece: Piece? = null) : Cordinate{
    override fun pieceArrival(piece: Piece): CordinateWithPiece {
        return CordinateWithPiece(x, y, piece)
    }

    override fun pieceDeparture(): EmptyCordinate {
        return EmptyCordinate(x,y)
    }

    override fun hasPiece(): Boolean {
        return false;
    }

}