package org.example.game.piece

import org.example.game.Validator.SpecialValidatorMove
import org.example.game.Validator.ValidatorMove

interface Piece{
    val id : Int
    val color : Color?
    val type : String?
    val validator : List<ValidatorMove>?
    val data : HashMap<String , Integer>
    val dead : Boolean
    fun getSpecialMoves() : List<SpecialValidatorMove>
}