package org.example.game.Validator.pieces

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.Status
import org.example.game.Validator.ValidatorMove
import org.example.game.Validator.move.DiagonalValidatorMove
import org.example.game.Validator.move.HorizontalValidatorMove
import org.example.game.Validator.move.VerticalValidatorMove
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class JuggerValidatorPiece() : GeneralValidator() {

    private var level : Int = 1

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Status {
        if (validatecommonConditions(Cordinate1, Cordinate2, color, board).bool) {
                    val listOfValidators = listOf<ValidatorMove>(VerticalValidatorMove(level , false), VerticalValidatorMove(level , true), HorizontalValidatorMove(level , false), HorizontalValidatorMove(level , true), DiagonalValidatorMove(level , listOf(1,2,3,4)))
                    for (validator in listOfValidators){
                        if (validator.validate(Cordinate1, Cordinate2, color, board).bool){
                            if (Cordinate2.hasPiece()){
                                if (Cordinate2.piece?.getColor() != color){
                                    Cordinate1.piece?.data?.put("kills", Cordinate1.piece?.data?.get("kills")!! + 1)
                                    if (Cordinate1.piece?.data?.get("kills")?.rem(3) == 0){
                                        level++
                                    }
                                }
                            }
                            return Status(true , "")
                        }
                    }
                } else {
                    throw Exception(validatecommonConditions(Cordinate1, Cordinate2, color, board).error)
                }
        return Status(false , "Invalid move")
    }
}