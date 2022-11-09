package org.example.game.Validator.move

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.Status
import org.example.game.Validator.ValidatorMove
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class HorizontalValidatorMove (val limit : Int, val left : Boolean): ValidatorMove {

    private val generalValidator = GeneralValidator()

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board : Board): Status {
        var limit = limit
        if (limit === 0){
            limit = board.getBoardWidth()
        }
            if (generalValidator.validateIsItMyPiece(Cordinate1, color).bool){
                if(generalValidator.validateCordinate1EqualsCordinate2(Cordinate1, Cordinate2).bool){
                    if(generalValidator.validateAllyPieceInSecondCordinate(Cordinate2 , color).bool) {
                        if (generalValidator.validatePiecesInBetween(Cordinate1, Cordinate2, board).bool){
                                var x = Cordinate1.x
                                if (left){
                                    x -= limit
                                    if (x <= Cordinate2.x && Cordinate1.y == Cordinate2.y && Cordinate1.x > Cordinate2.x){
                                        return Status(true, "")
                                    }
                                }else{
                                    x += limit
                                    if (x >= Cordinate2.x && Cordinate1.y == Cordinate2.y && Cordinate1.x < Cordinate2.x){
                                        return Status(true, "")
                                    }
                                }
                        }else{
                            return generalValidator.validatePiecesInBetween(Cordinate1, Cordinate2, board)
                        }
                    }else{
                        return generalValidator.validateAllyPieceInSecondCordinate(Cordinate2, color)
                    }
                }else {
                    return generalValidator.validateCordinate1EqualsCordinate2(Cordinate1, Cordinate2)
                }
            }else {
                return generalValidator.validateIsItMyPiece(Cordinate1, color)
            }
            return Status(false, "Invalid move")
    }

}