package org.example.game.Validator.special

import org.example.game.Validator.*
import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.CordinateWithPiece
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color
import org.example.game.piece.Piece

class CastleValidator() : SpecialValidatorMove, GeneralValidator() {
    override fun positionFinal(color : Color, board : Board, cordinate2 : Cordinate): List<Cordinate> {
        var y = 1
        if (color == Color.BLACK){
            y = 8
        }
        var list : List<Cordinate> = ArrayList()
            if (cordinate2.x == 2) {
                list = listOf(CordinateWithPiece(3, y, board.getCordinate(1, y).piece), CordinateWithPiece(4, y, board.getCordinate(5, y).piece), EmptyCordinate(1, y), EmptyCordinate(5, y))
            } else if (cordinate2.x == 7) {
                list = listOf(CordinateWithPiece(6, y, board.getCordinate(8, y).piece), CordinateWithPiece(7, y, board.getCordinate(5, y).piece), EmptyCordinate(8, y), EmptyCordinate(5, y))
            }
        return list
    }

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Status {
        if (validatecommonConditions(Cordinate1 , Cordinate2 , color, board).bool){
            if (Cordinate2.x == 2){
                    return validateLeftSide(Cordinate1, Cordinate2, board, color)
                }else{
                    return validateRightSide(Cordinate1, Cordinate2, board, color)
                }
        }else{
                throw Exception(validatecommonConditions(Cordinate1 , Cordinate2 , color, board).error)
        }
        return Status(false, "Invalid move")
    }


    fun validateRook(x : Int , y : Int, board : Board, color : Color) : Boolean{
        val rook : Piece = board.getCordinate(x,y).piece!!
        if(rook.type == "rook" && rook.data.get("moves") == 0 && rook.getColor() == color){
            return true
        }
        return false
    }

    fun validateKing(x : Int , y : Int, board : Board, color : Color) : Boolean{
        val king : Piece = board.getCordinate(x,y).piece!!
        if (king.type == "king" && king.data.get("moves") == 0 && king.getColor() == color){
            return true
        }
        return false
    }

    fun validateLeftSide (Cordinate1: Cordinate, Cordinate2: Cordinate ,board : Board, color : Color) : Status{
        var y = 1
        if (color == Color.BLACK){
            y = 8
        }
        if (Cordinate1.x == 5 && Cordinate1.y == y && Cordinate2.x == 2 && Cordinate2.y == y){

        if (board.getCordinate(2,y) is EmptyCordinate && board.getCordinate(3,y) is EmptyCordinate && board.getCordinate(4,y) is EmptyCordinate){
            if (validateRook(1,y,board,color) && validateKing(5,y,board,color)){
                    val checkValidator = CheckValidator(WinCondition(listOf<Piece>(board.getCordinate(5,y).piece!!)))
                    if (checkValidator.validate(board, color)){ return Status(false, "You can't castle because you are in check") }
                    val Board = board.updateBoard(CordinateWithPiece(5, y, board.getCordinate(5, y).piece), CordinateWithPiece(7, y, null))
                    if (checkValidator.validate(Board, color)){ return Status(false, "You can't castle because you will be in check")}
                    return Status(true, "")
                }else{
                    return Status(false, "You can't castle because the king or the rook has moved")
                }
            }
        }
        return Status(false, "Invalid move")
    }


    fun validateRightSide (Cordinate1: Cordinate, Cordinate2: Cordinate ,board : Board, color : Color) : Status{
        var y = 1
        if (color == Color.BLACK){
            y = 8
        }
        if (Cordinate1.x == 5 && Cordinate1.y == y && Cordinate2.x == 7 && Cordinate2.y == y){
            if (board.getCordinate(6,y) is EmptyCordinate && board.getCordinate(7,y) is EmptyCordinate){
                if (validateRook(8,y,board,color) && validateKing(5,y,board,color)){
                        val checkValidator = CheckValidator(WinCondition(listOf<Piece>(board.getCordinate(5,y).piece!!)))
                        if (checkValidator.validate(board, color)){ return Status(false, "You can't castle because you are in check") }
                        val Board = board.updateBoard(CordinateWithPiece(5, y, board.getCordinate(5, y).piece), CordinateWithPiece(7, y, null))
                        if (checkValidator.validate(Board, color)){ return Status(false, "You can't castle because you will be in check")}
                        return Status(true, "")
                    }else{
                        return Status(false, "You can't castle because the king or the rook has moved")
                    }
                }
            }
        return Status(false, "Invalid move")
    }



}