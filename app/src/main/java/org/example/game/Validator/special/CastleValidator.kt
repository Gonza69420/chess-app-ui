package org.example.game.Validator.special

import org.example.game.Validator.SpecialValidatorMove
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class CastleValidator(override val positionsInitial: List<EmptyCordinate>, override val positionFinal: List<EmptyCordinate>) : SpecialValidatorMove {


    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Boolean {
        TODO("Not yet implemented")
    }
}