package org.example.game

import org.example.game.Validator.CheckValidator
import org.example.game.Validator.PromoteValidator
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color
import org.example.game.piece.Piece
import org.example.game.piece.PieceWithoutSpecialMove

class MoverClassic(val checkValidator: CheckValidator, val promotionPiece: Piece) {

    val winCondition: WinCondition = checkValidator.getWinCondition()
    val PromoteValidator = PromoteValidator()

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
        if (Cordinate1.piece?.getColor() != color) {
            throw Exception("Its not your turn")
        }
        for (i in Cordinate1.piece!!.getValidators()) {
            val status = i.validate(Cordinate1, Cordinate2, color, board)
            if (status.bool) {
                var newBoard = board.updateBoard(Cordinate1, Cordinate2)
                if (checkValidator.validate(newBoard, color)) {
                    throw Exception("You can't your king in check")
                }
                Cordinate1.piece!!.data["moves"] = Cordinate1.piece!!.data["moves"]!! + 1
                if (PromoteValidator.validate(color, newBoard, newBoard.getCordinate(Cordinate2.x, Cordinate2.y)).bool) {
                    val oldPiece = newBoard.getCordinate(Cordinate2.x, Cordinate2.y).piece
                    if (oldPiece != null) {
                        newBoard = newBoard.promotePiece(Cordinate2 , PieceWithoutSpecialMove(oldPiece.id, oldPiece.getColor(), promotionPiece.type.toString(), promotionPiece.getValidators(), oldPiece.data))
                    }
                }
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
                val finaPosition = i.positionFinal(color, board, Cordinate2)
                for (j in finaPosition) {
                    if (j.hasPiece()) {
                        val cordinate = j.piece?.let { board.getCordinateByPieceId(it.id) }
                        newBoard = newBoard.updateBoard(cordinate!!, j)
                    }
                }
                if (checkValidator.validate(newBoard, color)) {
                    throw Exception("You can't your king in check")
                }
                if (PromoteValidator.validate(color, newBoard, Cordinate2).bool) {
                    val oldPiece = newBoard.getCordinate(Cordinate2.x, Cordinate2.y).piece
                    if (oldPiece != null) {
                        newBoard = newBoard.promotePiece(Cordinate2 , PieceWithoutSpecialMove(oldPiece.id, oldPiece.getColor(), promotionPiece.type.toString(), promotionPiece.getValidators(), oldPiece.data))
                    }
                }
                return newBoard
            }
        }


        throw Exception("Invalid move")
    }



}