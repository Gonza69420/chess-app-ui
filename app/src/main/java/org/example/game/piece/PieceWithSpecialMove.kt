package org.example.game.piece

import org.example.game.Validator.SpecialValidatorMove
import org.example.game.Validator.ValidatorMove

class PieceWithSpecialMove(override val color: Color, override val type: String, override val validator: List<ValidatorMove>, override val data: PieceData?, private val specialMoves : List<SpecialValidatorMove>) : Piece {
    override fun getSpecialMoves(): List<SpecialValidatorMove> {
        return specialMoves;
    }


}