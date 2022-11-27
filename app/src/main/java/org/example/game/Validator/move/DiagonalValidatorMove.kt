package org.example.game.Validator.move

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.Status
import org.example.game.Validator.ValidatorMove
import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class DiagonalValidatorMove(var limit : Int, val quadrant : List<Int>): GeneralValidator() {

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Status {
        if (limit == 0) limit = board.getBoardWidth()
        if (validatecommonConditions(Cordinate1, Cordinate2, color, board).bool) {
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
                        if (y + j == Cordinate2.y && x - j == Cordinate2.x) {
                            return Status(true, "")
                        }
                    }
                } else if (i == 3) {
                    for (j in 1..limit) {
                        if (y - j == Cordinate2.y && x - j == Cordinate2.x) {
                            return Status(true, "")
                        }
                    }
                } else if (i == 4) {
                    for (j in 1..limit) {
                        if (y - j == Cordinate2.y && x + j == Cordinate2.x) {
                            return Status(true, "")
                        }
                    }
                }
            }
        } else {
            throw Exception(validatecommonConditions(Cordinate1, Cordinate2, color, board).error)
        }
        return Status(false, "Invalid move")
    }
}