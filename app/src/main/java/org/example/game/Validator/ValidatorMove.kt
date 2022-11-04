package org.example.game.Validator

import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

interface ValidatorMove {

    fun validate(emptyCordinate1 : EmptyCordinate, emptyCordinate2 : EmptyCordinate, color : Color) : Boolean

}