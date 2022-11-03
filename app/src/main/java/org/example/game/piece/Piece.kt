package org.example.game.piece

import org.example.game.Validator.ValidatorMove

interface Piece{
    val color : Color?
    val type : String?
    val validator : ValidatorMove?
    val data : PieceData?

    fun isEmpty () : Boolean
}