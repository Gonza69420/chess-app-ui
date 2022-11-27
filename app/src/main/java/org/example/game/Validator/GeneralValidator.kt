package org.example.game.Validator

import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

abstract class GeneralValidator() : ValidatorMove {
    fun validatePiecesInBetween(cordinate1 : Cordinate, cordinate2 : Cordinate , board : Board) : Status{
        board.getCordinatesInBetween(cordinate1, cordinate2).forEach {
            if(it.hasPiece()){
                return Status(false , "There is a piece in between")
            }
        }
        return Status(true , "")
    }

    fun validateAllyPieceInSecondCordinate(cordinate2: Cordinate, color : Color) : Status{
        if(cordinate2.hasPiece() && cordinate2.piece?.getColor() == color){
            return Status(false , "There is an ally piece in the second cordinate")
        }
        return Status(true , "")
    }

    fun validateIsItMyPiece(cordinate1 : Cordinate, color : Color) : Status{
        if (cordinate1.piece?.getColor() != color){
            return Status(false , "You can't move the enemy piece")
        }
        return Status(true , "")
    }

    fun validateCordinate1EqualsCordinate2(cordinate1 : Cordinate, cordinate2 : Cordinate) : Status{
        if (cordinate1 == cordinate2){
            return Status(false , "You can't move to the same cordinate")
        }
        return Status(true , "")
    }

    fun validatecommonConditions(cordinate1: Cordinate, cordinate2: Cordinate, color: Color, board: Board): Status {
        if (validateIsItMyPiece(cordinate1, color).bool){
            if (validatePiecesInBetween(cordinate1, cordinate2 , board).bool){
                if (validateAllyPieceInSecondCordinate(cordinate2 , color).bool) {
                    if (validateCordinate1EqualsCordinate2(cordinate1, cordinate2).bool) {
                        return Status(true , "")
                    }else{
                        return validateCordinate1EqualsCordinate2(cordinate1, cordinate2)
                    }
                    } else {
                        return validateAllyPieceInSecondCordinate(cordinate2 , color)
                    }
                }else{
                    return validatePiecesInBetween(cordinate1, cordinate2 , board)
                }
        }else{
            return validateIsItMyPiece(cordinate1, color)
        }
    }

    fun validatePieceAnd2Cordinate(cordinate1: Cordinate, cordinate2: Cordinate, color: Color) : Status{
        if(validateIsItMyPiece(cordinate1, color).bool){
            if(validateCordinate1EqualsCordinate2(cordinate1, cordinate2).bool){
                if (validateAllyPieceInSecondCordinate(cordinate2 , color).bool) {
                    return Status(true , "")
            }else{
                return validateAllyPieceInSecondCordinate(cordinate2, color)
            }
            }else{
                return validateCordinate1EqualsCordinate2(cordinate1, cordinate2)
            }
        }else{
            return validateIsItMyPiece(cordinate1, color)
        }
    }

}