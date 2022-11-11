package org.example.game

import org.example.game.Validator.AntiChessValidator
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class MoverAnti() {
        private val antiChessValidator: AntiChessValidator = AntiChessValidator()

        fun movePiece(cordinate1: Cordinate, cordinate2: Cordinate, board: Board, turn: Color): Board {
            val status = antiChessValidator.validate(turn, board, cordinate2)
            if (status.bool) {
                    var enemyColor : Color
                    if (turn == Color.WHITE){
                        enemyColor = Color.BLACK
                    } else {
                        enemyColor = Color.WHITE
                    }
                    if (cordinate1.piece?.color != turn) {
                        throw Exception("Its not your turn")
                    }
                    for (i in cordinate1.piece!!.getValidators()) {
                        val status = i.validate(cordinate1, cordinate2, turn, board)
                        if (status.bool) {
                            val newBoard = board.updateBoard(cordinate1, cordinate2)
                            cordinate1.piece!!.data["moves"] = cordinate1.piece!!.data["moves"]!! + 1
                            return newBoard
                        }
                    }

                    for (i in cordinate1.piece!!.getSpecialMoves()) {
                        val status = i.validate(cordinate1, cordinate2, turn, board)
                        if (status.bool) {
                            var newBoard = board.updateBoard(cordinate1, cordinate2)
                            cordinate1.piece!!.data["moves"] = cordinate1.piece!!.data["moves"]!! + 1
                            val finaPosition = i.positionFinal(turn, board, cordinate2)
                            for (j in finaPosition) {
                                if (j.hasPiece()) {
                                    val cordinate = j.piece?.let { board.getCordinateByPieceId(it.id) }
                                    newBoard = newBoard.updateBoard(cordinate!!, j)
                                }
                            }
                            return newBoard
                        }
                    }


                    throw Exception("Invalid move")
            }else{
                throw Exception(status.error)
            }
            throw Exception("Invalid move")
        }
}