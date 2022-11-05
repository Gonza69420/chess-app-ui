package org.example.game.Validator

import org.example.game.board.Board
import org.example.game.piece.Color

class CheckMateValidator(private val CheckValidator : CheckValidator) {

    fun validate(board: Board, color: Color): Boolean {
        if (CheckValidator.validate(board, color)) {
            val allyCordinates = board.getAllyCordinates(color)
            for (i in allyCordinates) {
                for (j in i.piece?.getValidators()!!) {
                    for (k in board.getCordinates()) {
                        if (j.validate(i, k, color, board).bool) {
                            val newBoard = board.updateBoard(i.pieceDeparture(), k.pieceArrival(i.piece!!))
                            if (!CheckValidator.validate(newBoard, color)) {
                                return false
                            }
                        }
                    }
                    for (j in i.piece!!.getSpecialMoves()) {
                        for (k in board.getCordinates()) {
                            if (j.validate(i, k, color, board).bool) {
                                val newBoard = board.updateBoard(i.pieceDeparture(), k.pieceArrival(i.piece!!))
                                if (!CheckValidator.validate(newBoard, color)) {
                                    return false
                                }
                            }
                        }
                    }
                }
            }
            return true
        }
        return false
    }

}