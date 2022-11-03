package org.example.game.piece

import org.example.game.Validator.ValidatorMove

class EmptyPiece(override val color: Color? = null, override val type: String? = null, override val validator: ValidatorMove? = null, override val data: PieceData? = null) : Piece {
    override fun isEmpty(): Boolean {
        return true
    }
}