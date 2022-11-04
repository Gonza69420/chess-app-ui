package org.example.game.Validator

import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class GeneralValidator(winCondition : WinCondition) {
    fun validatePiecesInBetween(cordinate1 : Cordinate, cordinate2 : Cordinate , board : Board) : Boolean{

    }

    fun validateAllyPieceInSecondCordinate(cordinate2: Cordinate, color : Color) : Boolean{
        return cordinate2.piece?.color != color
    }

    fun validateWinConditionInSecondCordinate(cordinate2: Cordinate) : Boolean{}

    fun validateIsItMyPiece(cordinate1 : Cordinate, color : Color) : Boolean{
        return if(cordinate1.hasPiece()){
            cordinate1.piece?.color == color
        }else{
            false
        }
    }

}