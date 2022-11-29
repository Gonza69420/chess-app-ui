package org.example.game.Validator

import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class AntiChessValidator() {

    fun validate(color: Color, board: Board, Cordinate2 : Cordinate): Status {
        try{
        val allyCordinates = board.getAllyCordinates(color)
        if (Cordinate2.hasPiece()) {
            if (Cordinate2.piece?.getColor() != color) {
                return Status(true, "")
            }
        }
        for (i in allyCordinates) {
            for (j in i.piece?.getValidators()!!) {
                if(validateAnti(j, i, color, board )) return Status(false , "There is a Piece you can Eat")
            }
            for (j in i.piece!!.getSpecialMoves()) {
                if(validateAnti(j, i, color, board )) return Status(false , "There is a Piece you can Eat")
            }
        }
        return Status(true , "")
    }
    catch (e : Exception){
        return Status(false , "Invalid move")
    }
    }


    fun validateAnti(validator : ValidatorMove, allyCordinate : Cordinate, color : Color, board: Board) : Boolean{
        val enemyCordinates = board.getEnemyCordinates(color)
        for (k in enemyCordinates) {
            try {
                if (validator.validate(allyCordinate, k, color, board).bool) {
                    return true
                }
            } catch (e: Exception) {
                continue
            }
        }
        return false
    }
}
