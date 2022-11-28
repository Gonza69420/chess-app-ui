package org.example.game.Validator

import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class CheckMateValidator(private val CheckValidator : CheckValidator) {

    fun validate(board: Board, color: Color): Boolean {
            if (CheckValidator.validate(board, color)) {
                val allyCordinates = board.getAllyCordinates(color)
                for (i in allyCordinates) {
                    for (j in i.piece?.getValidators()!!) {
                        if (!validateCheckMate(j , i , color , board)) return false
                    }
                        for (j in i.piece!!.getSpecialMoves()) {
                            if (!validateCheckMate(j , i , color , board)) return false
                        }
                }
                return true
            }
        return false
    }

    private fun validateCheckMate (validator : ValidatorMove, allyCordinate : Cordinate, color : Color, board : Board) : Boolean{
        for (k in board.getCordinates()) {
            try {
                if (validator.validate(allyCordinate, k, color, board).bool) {
                    val newBoard = board.updateBoard(allyCordinate, k)
                    if (!CheckValidator.validate(newBoard, color)) {
                        return false
                    }
                }
            } catch (e: Exception) {
                continue
            }
        }
        return true
    }

}