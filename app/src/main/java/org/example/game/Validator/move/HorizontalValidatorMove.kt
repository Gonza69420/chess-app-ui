package org.example.game.Validator.move

import org.example.game.Validator.ValidatorMove
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class HorizontalValidatorMove (
    val limit : Int,
    val direction : Boolean
        ): ValidatorMove {
    override fun validate(cordinate1: Cordinate, cordinate2: Cordinate, color: Color): Boolean {
        TODO("Not yet implemented")
    }
}