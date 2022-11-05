package org.example.game.Validator

import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

interface ValidatorMove {

    fun validate(Cordinate1 : Cordinate, Cordinate2 : Cordinate, color : Color, board : Board) : Status

}