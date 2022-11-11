package org.example.game

import org.example.game.Validator.CheckMateValidator
import org.example.game.Validator.CheckValidator
import org.example.game.board.Board
import org.example.game.piece.Color
import org.example.game.piece.Piece

class AntiChessGame (
    private val board : Board,
    private val winCondition : WinCondition,
    private val turn : Color,
    private val promotionPiece : Piece
) {
    private val moverAnti : MoverAnti = MoverAnti(promotionPiece)


    fun changeTurn () : Color {
        if (turn == Color.WHITE){
            return Color.BLACK
        }
        return Color.WHITE
    }

    fun isItCheckMate () : Boolean {
        return board.getAllyCordinates(turn).isEmpty()
    }

    fun movePiece (x1 : Int , y1 : Int , x2 : Int , y2 : Int) : AntiChessGame {
        val cordinate1 = board.getCordinate(x1 , y1)
        val cordinate2 = board.getCordinate(x2 , y2)
        val newBoard = moverAnti.movePiece(cordinate1 , cordinate2 , board, turn)
        return AntiChessGame(newBoard , winCondition, changeTurn(), promotionPiece)
    }

    fun getBoard () : Board {
        return board
    }

    fun getTurn () : Color {
        return turn
    }

    fun getWinCondition () : WinCondition {
        return winCondition
    }

}