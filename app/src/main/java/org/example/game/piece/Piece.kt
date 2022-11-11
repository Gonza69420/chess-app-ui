package org.example.game.piece

import org.example.game.Validator.SpecialValidatorMove
import org.example.game.Validator.ValidatorMove

interface Piece{
    val id : Int
    val type : String?
    val validator : List<ValidatorMove>?
    var data : HashMap<String , Int>
    val dead : Boolean
    val promotion : Boolean
    fun getSpecialMoves() : List<SpecialValidatorMove>
    fun getValidators() : List<ValidatorMove>
    fun kill ( ) : Piece
    fun getColor() : Color

}