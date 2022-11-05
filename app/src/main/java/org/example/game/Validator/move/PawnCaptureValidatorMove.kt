package org.example.game.Validator.move

import edu.austral.dissis.chess.gui.SimpleGameEngine
import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.ValidatorMove
import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class PawnCaptureValidatorMove(
    val generalValidator: GeneralValidator
) : ValidatorMove {


    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Boolean {
        if (generalValidator.validateIsItMyPiece(Cordinate1, color)){
            if (generalValidator.validateAllyPieceInSecondCordinate(Cordinate2 , color) && generalValidator.validateCordinate1EqualsCordinate2(Cordinate1 , Cordinate2) && generalValidator.validateWinConditionInSecondCordinate(Cordinate2)){
                if (!Cordinate2.hasPiece()) return false

                if (color == Color.WHITE){
                    if (Cordinate1.x + 1 == Cordinate2.x && Cordinate1.y + 1 == Cordinate2.y){
                        return true
                    }else if (Cordinate1.x - 1 == Cordinate2.x && Cordinate1.y + 1 == Cordinate2.y){
                        return true
                    }
                }else{
                    if (Cordinate1.x + 1 == Cordinate2.x && Cordinate1.y - 1 == Cordinate2.y){
                        return true
                    }else if (Cordinate1.x - 1 == Cordinate2.x && Cordinate1.y - 1 == Cordinate2.y){
                        return true
                    }
                }
            }
        }

        return false
    }


}