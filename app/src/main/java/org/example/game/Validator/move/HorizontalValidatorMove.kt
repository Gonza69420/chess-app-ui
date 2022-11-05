package org.example.game.Validator.move

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.ValidatorMove
import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class HorizontalValidatorMove (
    val limit : Int,
    val direction : Boolean,
    val generalValidator: GeneralValidator
        ): ValidatorMove {

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board : Board): Boolean {
            if (generalValidator.validateIsItMyPiece(Cordinate1, color)){
                if(generalValidator.validateCordinate1EqualsCordinate2(Cordinate1, Cordinate2) && generalValidator.validateAllyPieceInSecondCordinate(Cordinate2 , color) && generalValidator.validateWinConditionInSecondCordinate(Cordinate2) && generalValidator.validatePiecesInBetween(Cordinate1, Cordinate2, board)){
                                var x = Cordinate1.x
                                if (direction){
                                    x += limit
                                    if (x > Cordinate2.x && Cordinate1.y == Cordinate2.y){
                                        return true
                                    }
                                }else{
                                    x -= limit
                                    if (x < Cordinate2.x && Cordinate1.y == Cordinate2.y){
                                        return true
                                    }
                                }
                }
            }
        return false
    }

}