package org.example.game

import org.example.game.Validator.CheckValidator
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class Mover(val checkValidator: CheckValidator) {

    val winCondition: WinCondition = checkValidator.getWinCondition()


    fun movePiece (Cordinate1 : Cordinate, Cordinate2 : Cordinate, board : Board, color : Color) : Board {
        var enemyColor : Color
        if (color == Color.WHITE){
            enemyColor = Color.BLACK
        } else {
            enemyColor = Color.WHITE
        }
        val listOfwinCondition = winCondition.getIdOfWinConditionPieceAliveByColor( enemyColor, board)
        if (listOfwinCondition.size == 1) {
            if (Cordinate2.piece?.id == listOfwinCondition.get(0)) {
                throw Exception("You can't capture the last win condition")
            }
        }
        if (Cordinate1.piece?.color != color) {
            throw Exception("Its not your turn")
        }
        for (i in Cordinate1.piece!!.getValidators()) {
            val status = i.validate(Cordinate1, Cordinate2, color, board)
            if (status.bool) {
                val newBoard = board.updateBoard(Cordinate1, Cordinate2)
                if (checkValidator.validate(newBoard, color)) {
                    throw Exception("You can't your king in check")
                }
                Cordinate1.piece!!.data["moves"] = Cordinate1.piece!!.data["moves"]!! + 1
                return newBoard
            }
        }

        for (i in Cordinate1.piece!!.getSpecialMoves()) {
            val status = i.validate(Cordinate1, Cordinate2, color, board)
            if (status.bool) {
                var newBoard = board.updateBoard(Cordinate1, Cordinate2)
                if (checkValidator.validate(newBoard, color)) {
                    throw Exception("You can't your king in check")
                }
                Cordinate1.piece!!.data["moves"] = Cordinate1.piece!!.data["moves"]!! + 1
                val finaPosition = i.positionFinal(color)
                for (j in finaPosition) {
                    if (j.hasPiece()) {
                        val cordinate = j.piece?.let { board.getCordinateByPieceId(it.id) }
                        newBoard = newBoard.updateBoard(cordinate!!, j)
                    }
                }
                if (checkValidator.validate(newBoard, color)) {
                    throw Exception("You can't your king in check")
                }
                return newBoard
            }
        }


        throw Exception("Invalid move")
    }



}