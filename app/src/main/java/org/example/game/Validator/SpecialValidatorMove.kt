package org.example.game.Validator

import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

interface SpecialValidatorMove : ValidatorMove {
    fun positionFinal(color : Color, board : Board, cordinate2 : Cordinate) : List<Cordinate>

}
