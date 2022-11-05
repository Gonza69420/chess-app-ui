package org.example.game.Validator

import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.piece.Color

class CheckValidator(private val winCondition: WinCondition) {

    fun validate(board : Board, color : Color) : Boolean{
        val idOfPieces = winCondition.getIdOfWinConditionPieceAliveByColor(color, board)
        if (idOfPieces.size == 1){
            val enemyCordinate = board.getEnemyCordinates(color)
            for (i in enemyCordinate){
                for (j in i.piece?.getValidators()!!){
                    if (j.validate(i , board.getCordinateByPieceId(idOfPieces.get(0)) , color , board).bool){
                        return true
                    }
                }
                for (j in i.piece!!.getSpecialMoves()){
                    if (j.validate(i , board.getCordinateByPieceId(idOfPieces.get(0)) , color , board).bool){
                        return true
                    }
                }
            }
        }
        return false
    }

    fun getWinCondition() : WinCondition{
        return winCondition
    }
}