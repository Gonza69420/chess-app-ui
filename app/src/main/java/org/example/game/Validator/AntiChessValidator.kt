package org.example.game.Validator

import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class AntiChessValidator() {

    fun validate(color: Color, board: Board): Status {
        val allyCordinates = board.getAllyCordinates(color)
        val enemyCordinates = board.getEnemyCordinates(color)
        for (i in allyCordinates) {
            for (j in i.piece?.getValidators()!!) {
                for (k in enemyCordinates) {
                    if (j.validate(i, k, color, board).bool) {
                        return Status(false , "There is a Piece you can Eat")
                    }
                }
            }
            for (j in i.piece!!.getSpecialMoves()) {
                for (k in enemyCordinates) {
                    if (j.validate(i, k, color, board).bool) {
                        return Status(false , "There is a Piece you can Eat")
                    }
                }
            }
        }
        return Status(true , "")
    }
}
