package org.example.game.Validator.move

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.Status
import org.example.game.Validator.ValidatorMove
import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class DiagonalValidatorMove(var limit : Int, val quadrant : List<Int>): ValidatorMove {
    private val generalValidator: GeneralValidator = GeneralValidator()

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Status {
        if (limit == 0) limit = board.getBoardWidth()
        if (generalValidator.validateIsItMyPiece(Cordinate1, color).bool) {
            if (generalValidator.validateCordinate1EqualsCordinate2(Cordinate1, Cordinate2).bool) {
                    if(generalValidator.validateAllyPieceInSecondCordinate(Cordinate2, color).bool) {
                        if (generalValidator.validatePiecesInBetween(Cordinate1, Cordinate2, board).bool){
                            var y = Cordinate1.y
                            var x = Cordinate1.x
                            for (i in quadrant) {
                                if (i == 1) {
                                    for (j in 1..limit) {
                                        if (y + j == Cordinate2.y && x + j == Cordinate2.x) {
                                            return Status(true, "")
                                        }

                                    }
                                } else if (i == 2) {
                                    for (j in 1..limit) {
                                        if (y+j == Cordinate2.y && x-j == Cordinate2.x) {
                                            return Status(true, "")
                                        }
                                    }
                                } else if (i == 3) {
                                    for (j in 1..limit) {
                                        if (y-j == Cordinate2.y && x-j == Cordinate2.x) {
                                            return Status(true, "")
                                        }
                                    }
                                } else if (i == 4) {
                                    for (j in 1..limit) {
                                        if (y-j == Cordinate2.y && x+j == Cordinate2.x) {
                                            return Status(true, "")
                                        }
                                    }
                                }
                            }
                        }else{
                            return generalValidator.validatePiecesInBetween(Cordinate1, Cordinate2, board)
                        }
                    }else{
                        return generalValidator.validateAllyPieceInSecondCordinate(Cordinate2, color)
                    }
            } else {
                return generalValidator.validateCordinate1EqualsCordinate2(Cordinate1, Cordinate2)
            }
        }else {
            return generalValidator.validateIsItMyPiece(Cordinate1, color)
        }
        return Status(false, "You can't move there")
    }
}