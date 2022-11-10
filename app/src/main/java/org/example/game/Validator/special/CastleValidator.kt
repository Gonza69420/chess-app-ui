package org.example.game.Validator.special

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.SpecialValidatorMove
import org.example.game.Validator.Status
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.CordinateWithPiece
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color
import org.example.game.piece.Piece

class CastleValidator() : SpecialValidatorMove {

    private val generalValidator: GeneralValidator = GeneralValidator()

    override fun positionFinal(color : Color, board : Board, cordinate2 : Cordinate): List<Cordinate> {
        var list : List<Cordinate> = ArrayList()
        if (color == Color.WHITE) {
            if (cordinate2.x == 2) {
                list = listOf(CordinateWithPiece(3, 1, board.getCordinate(1, 1).piece), CordinateWithPiece(4, 1, board.getCordinate(5, 1).piece), EmptyCordinate(1, 1), EmptyCordinate(5, 1))
            } else if (cordinate2.x == 6) {
                list = listOf(CordinateWithPiece(5, 1, board.getCordinate(8, 1).piece), CordinateWithPiece(6, 1, board.getCordinate(5, 1).piece), EmptyCordinate(8, 1), EmptyCordinate(5, 1))
            }
        } else {
            if (cordinate2.x == 2) {
                list = listOf(
                    CordinateWithPiece(3, 8, board.getCordinate(1, 8).piece),
                    CordinateWithPiece(4, 8, board.getCordinate(5, 8).piece),
                    EmptyCordinate(1, 8),
                    EmptyCordinate(5, 8)
                )
            } else if (cordinate2.x == 6) {
                list = listOf(
                    CordinateWithPiece(5, 8, board.getCordinate(8, 8).piece),
                    CordinateWithPiece(6, 8, board.getCordinate(5, 8).piece),
                    EmptyCordinate(8, 8),
                    EmptyCordinate(5, 8)
                )
            }
        }
        return list
    }

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Status {
        if (color == Color.WHITE){
            if(generalValidator.validateCordinate1EqualsCordinate2(Cordinate1, Cordinate2).bool && generalValidator.validateAllyPieceInSecondCordinate(Cordinate2 , color).bool && generalValidator.validatePiecesInBetween(Cordinate1, Cordinate2, board).bool){
                if (Cordinate1.x == 5 && Cordinate1.y == 1 && Cordinate2.x == 2 && Cordinate2.y == 1){
                    if (board.getCordinate(2,1) is EmptyCordinate && board.getCordinate(3,1) is EmptyCordinate && board.getCordinate(4,1) is EmptyCordinate ) {
                        if(validateRook(1 , 1 , board , color) && validateKing(5,1,board,color)){
                            // TODO: check if the king is in check

                            return Status(true, "")
                        }

                    }
                }else if (Cordinate1.x == 5 && Cordinate1.y == 1 && Cordinate2.x == 7 && Cordinate2.y == 1){
                    if (board.getCordinate(6,1) is EmptyCordinate && board.getCordinate(7,1) is EmptyCordinate){
                        if(validateRook(8,1,board,color) && validateKing(5,1,board,color)){
                            // TODO: check if the king is in check

                            return Status(true, "")
                        }
                    }
                }

            }
        }
        return Status(false, "Invalid move")
    }


    fun validateRook(x : Int , y : Int, board : Board, color : Color) : Boolean{
        val rook : Piece = board.getCordinate(x,y).piece!!
        if(rook.type == "rook" && rook.data.get("moves") == 0 && rook.color == color){
            return true
        }
        return false
    }

    fun validateKing(x : Int , y : Int, board : Board, color : Color) : Boolean{
        val king : Piece = board.getCordinate(x,y).piece!!
        if (king.type == "king" && king.data.get("moves") == 0 && king.color == color){
            return true
        }
        return false
    }

}