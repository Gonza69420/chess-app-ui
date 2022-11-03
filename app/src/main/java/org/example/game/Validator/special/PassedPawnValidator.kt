package org.example.game.Validator.special

import org.example.game.Validator.SpecialValidatorMove
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class PassedPawnValidator(override val positionsInitial: List<Cordinate>, override val positionFinal: List<Cordinate>) :  SpecialValidatorMove{
    override fun validate(cordinate1: Cordinate, cordinate2: Cordinate, color: Color): Boolean {
        TODO("Not yet implemented")
    }
}