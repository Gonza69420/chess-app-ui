package org.example.game.Validator

import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class GeneralValidator(private val winCondition : WinCondition) {
    fun validatePiecesInBetween(cordinate1 : Cordinate, cordinate2 : Cordinate , board : Board) : Boolean{
        board.getCordinatesInBetween(cordinate1, cordinate2).forEach {
            if(it.hasPiece()){
                return false
            }
        }
        return true
    }

    fun validateAllyPieceInSecondCordinate(cordinate2: Cordinate, color : Color) : Boolean{
        return cordinate2.piece?.color != color
    }

    fun validateWinConditionInSecondCordinate(cordinate2: Cordinate) : Boolean{
        for (winCondition in winCondition.pieces){
            if (winCondition == cordinate2.piece){
                return false
            }
        }
        return true
    }

    fun validateIsItMyPiece(cordinate1 : Cordinate, color : Color) : Boolean{
        return if(cordinate1.hasPiece()){
            cordinate1.piece?.color == color
        }else{
            false
        }
    }

    fun validateCordinate1EqualsCordinate2(cordinate1 : Cordinate, cordinate2 : Cordinate) : Boolean{
        return cordinate1.x != cordinate2.x && cordinate1.y != cordinate2.y
    }

}