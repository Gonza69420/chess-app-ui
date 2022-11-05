package org.example.game.piece

import org.example.game.Validator.SpecialValidatorMove
import org.example.game.Validator.ValidatorMove

class PieceWithSpecialMove(override val id : Int, override val color: Color, override val type: String, override val validator: List<ValidatorMove>, override val data: HashMap<String , Int>, private val specialMoves : List<SpecialValidatorMove>, override val dead : Boolean = false) : Piece {
    override fun getSpecialMoves(): List<SpecialValidatorMove> {
        return specialMoves;
    }

    override fun getValidators(): List<ValidatorMove> {
        return validator;
    }

    override fun kill( ) : Piece{
        return PieceWithoutSpecialMove(id, color, type, validator, data, true)
    }


}