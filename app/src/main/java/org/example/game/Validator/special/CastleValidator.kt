package org.example.game.Validator.special

import org.example.game.Validator.SpecialValidatorMove
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class CastleValidator(override val positionsInitial: List<EmptyCordinate>, override val positionFinal: List<EmptyCordinate>) : SpecialValidatorMove {
    override fun validate(emptyCordinate1: EmptyCordinate, emptyCordinate2: EmptyCordinate, color: Color): Boolean {
        TODO("Not yet implemented")
    }
}