package org.example.game

import org.example.game.Validator.AntiChessValidator
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class MoverAnti() {
        private val antiChessValidator: AntiChessValidator = AntiChessValidator()

        fun movePiece(cordinate1: Cordinate, cordinate2: Cordinate, board: Board, turn: Color): Board {
            val status = antiChessValidator.validate(turn, board)
            if (antiChessValidator.validate(turn, board).bool) {
                fun movePiece (Cordinate1 : Cordinate, Cordinate2 : Cordinate, board : Board, color : Color) : Board {
                    var enemyColor : Color
                    if (color == Color.WHITE){
                        enemyColor = Color.BLACK
                    } else {
                        enemyColor = Color.WHITE
                    }
                    if (Cordinate1.piece?.color != color) {
                        throw Exception("Its not your turn")
                    }
                    for (i in Cordinate1.piece!!.getValidators()) {
                        val status = i.validate(Cordinate1, Cordinate2, color, board)
                        if (status.bool) {
                            val newBoard = board.updateBoard(Cordinate1, Cordinate2)
                            Cordinate1.piece!!.data["moves"] = Cordinate1.piece!!.data["moves"]!! + 1
                            return newBoard
                        }
                    }

                    for (i in Cordinate1.piece!!.getSpecialMoves()) {
                        val status = i.validate(Cordinate1, Cordinate2, color, board)
                        if (status.bool) {
                            var newBoard = board.updateBoard(Cordinate1, Cordinate2)
                            Cordinate1.piece!!.data["moves"] = Cordinate1.piece!!.data["moves"]!! + 1
                            val finaPosition = i.positionFinal(color, board, Cordinate2)
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
                }
            }else{
                throw Exception(status.error)
            }
            throw Exception("Invalid move")
        }
}