package org.example.game.board

import org.example.game.piece.Piece

class EmptyCordinate : Cordinate{
    override fun pieceArrival(Piece: Piece): CordinateWithPiece {
        TODO("Not yet implemented")
    }

    override fun pieceDeparture(): EmptyCordinate {
        TODO("Not yet implemented")
    }

    override fun hasPiece(): Boolean {
        return false;
    }

}