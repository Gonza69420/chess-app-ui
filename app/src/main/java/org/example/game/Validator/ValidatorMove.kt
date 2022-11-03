package org.example.game.Validator

import org.example.game.board.Cordinate
import org.example.game.piece.Color

interface ValidatorMove {

    fun validate(cordinate1 : Cordinate , cordinate2 : Cordinate, color : Color) : Boolean

}