package org.example.game.Validator.move

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.Status
import org.example.game.Validator.ValidatorMove
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class VerticalValidatorMove (val limit : Int, val up : Boolean) : GeneralValidator() {

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Status {
        var limit = limit
        if (limit === 0){
            limit = board.getBoardWidth()
        }
            if (validatecommonConditions(Cordinate1, Cordinate2, color, board).bool) {
                            var y = Cordinate1.y
                            if (up){
                                y -= limit
                                if (y <= Cordinate2.y && Cordinate1.x == Cordinate2.x && Cordinate1.y > Cordinate2.y){
                                    return Status(true, "")
                                }
                            }else{
                                y += limit
                                if (y >= Cordinate2.y && Cordinate1.x == Cordinate2.x && Cordinate1.y < Cordinate2.y){
                                    return Status(true, "")
                                }
                            }
            }else{
                throw Exception(validatecommonConditions(Cordinate1, Cordinate2, color, board).error)
            }
            return Status(false, "Invalid move")
    }
}