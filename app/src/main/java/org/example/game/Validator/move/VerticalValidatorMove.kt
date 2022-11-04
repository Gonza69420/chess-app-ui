package org.example.game.Validator.move

import org.example.game.Validator.ValidatorMove
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class VerticalValidatorMove (
    limit : Int,
    direction : Boolean
        ) : ValidatorMove {
    override fun validate(emptyCordinate1: EmptyCordinate, emptyCordinate2: EmptyCordinate, color: Color): Boolean {
        TODO("Not yet implemented")
    }
}