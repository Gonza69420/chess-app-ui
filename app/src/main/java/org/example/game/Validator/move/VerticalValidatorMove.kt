package org.example.game.Validator.move

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.Status
import org.example.game.Validator.ValidatorMove
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class VerticalValidatorMove (val limit : Int, val up : Boolean) : ValidatorMove {

    private val generalValidator: GeneralValidator = GeneralValidator()

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Status {
            if (generalValidator.validateIsItMyPiece(Cordinate1, color).bool) {
                if (generalValidator.validateCordinate1EqualsCordinate2(Cordinate1, Cordinate2).bool){
                    if (generalValidator.validateAllyPieceInSecondCordinate(Cordinate2, color).bool){
                        if(generalValidator.validatePiecesInBetween(Cordinate1, Cordinate2, board).bool){
                            var y = Cordinate1.y
                            if (up){
                                y += limit
                                if (y > Cordinate2.y && Cordinate1.x == Cordinate2.x){
                                    return Status(true, "")
                                }
                            }else{
                                y -= limit
                                if (y < Cordinate2.y && Cordinate1.x == Cordinate2.x){
                                    return Status(true, "")
                                }
                            }
                        }else{
                            return generalValidator.validatePiecesInBetween(Cordinate1, Cordinate2, board)
                        }
                    }else{
                        return generalValidator.validateAllyPieceInSecondCordinate(Cordinate2, color)
                    }
                }else{
                    return generalValidator.validateCordinate1EqualsCordinate2(Cordinate1, Cordinate2)
                }
            } else {
                return generalValidator.validateIsItMyPiece(Cordinate1, color)
            }
            return Status(false, "Invalid move")
    }
}