package org.example.game.piece

import org.example.game.Validator.SpecialValidatorMove
import org.example.game.Validator.ValidatorMove

interface Piece{
    val color : Color?
    val type : String?
    val validator : List<ValidatorMove>?
    val data : PieceData?

    fun getSpecialMoves() : List<SpecialValidatorMove>
}