package org.example.game

import org.example.game.Validator.CheckMateValidator
import org.example.game.Validator.CheckValidator
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class Game(
    private val board : Board,
    private val winCondition : WinCondition,
    private val turn : Color,
) {
    private val checkValidator : CheckValidator = CheckValidator( winCondition)
    private val checkMateValidator : CheckMateValidator = CheckMateValidator(checkValidator)
    private val mover : Mover = Mover(checkValidator)


    fun changeTurn () : Color {
        if (turn == Color.WHITE){
            return Color.BLACK
        }
        return Color.WHITE
    }

    fun isItCheckMate () : Boolean {
        return checkMateValidator.validate(board , turn)
    }

    fun isItCheck () : Boolean {
        return checkValidator.validate(board , turn)
    }

    fun movePiece (x1 : Int , y1 : Int , x2 : Int , y2 : Int) : Game {
        val cordinate1 = board.getCordinate(x1 , y1)
        val cordinate2 = board.getCordinate(x2 , y2)
        val newBoard = mover.movePiece(cordinate1 , cordinate2 , board, turn)
        return Game(newBoard , winCondition, changeTurn())
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