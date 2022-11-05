package org.example.game.Validator.pieces

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.Status
import org.example.game.Validator.ValidatorMove
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class KnightValidatorMove() : ValidatorMove {
    private val generalValidator = GeneralValidator()

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Status {
        if (generalValidator.validateIsItMyPiece(Cordinate1, color).bool){
            if (generalValidator.validateAllyPieceInSecondCordinate(Cordinate2 , color).bool){
                if (generalValidator.validateCordinate1EqualsCordinate2(Cordinate1 , Cordinate2).bool){
                    if (Cordinate1.x + 2 == Cordinate2.x && Cordinate1.y + 1 == Cordinate2.y){
                        return Status(true , "")
                    }else if (Cordinate1.x + 2 == Cordinate2.x && Cordinate1.y - 1 == Cordinate2.y){
                        return Status(true , "")
                    }else if (Cordinate1.x - 2 == Cordinate2.x && Cordinate1.y + 1 == Cordinate2.y){
                        return Status(true , "")
                    }else if (Cordinate1.x - 2 == Cordinate2.x && Cordinate1.y - 1 == Cordinate2.y){
                        return Status(true , "")
                    }else if (Cordinate1.x + 1 == Cordinate2.x && Cordinate1.y + 2 == Cordinate2.y){
                        return Status(true , "")
                    }else if (Cordinate1.x + 1 == Cordinate2.x && Cordinate1.y - 2 == Cordinate2.y){
                        return Status(true , "")
                    }else if (Cordinate1.x - 1 == Cordinate2.x && Cordinate1.y + 2 == Cordinate2.y){
                        return Status(true , "")
                    }else if (Cordinate1.x - 1 == Cordinate2.x && Cordinate1.y - 2 == Cordinate2.y){
                        return Status(true , "")
                    }
                }else {
                    return generalValidator.validateCordinate1EqualsCordinate2(Cordinate1 , Cordinate2)
                }
            }else {
                return generalValidator.validateAllyPieceInSecondCordinate(Cordinate2 , color)
            }
        }else {
            return generalValidator.validateIsItMyPiece(Cordinate1 , color)
        }
        return Status(false , "Invalid move")
    }
}