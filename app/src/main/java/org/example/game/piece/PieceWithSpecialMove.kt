package org.example.game.piece

import org.example.game.Validator.ValidatorMove

class PieceWithSpecialMove(override val color: Color, override val type: String, override val validator: ValidatorMove, override val data: PieceData?) : Piece {

    override fun isEmpty(): Boolean {
        return true;
    }
}