package org.example.game.Validator

import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class PromoteValidator {

    fun validate ( color : Color, board : Board, cordinate : Cordinate) : Status{
        if (cordinate.piece?.getColor() == color){
            if (cordinate.piece?.promotion == true){
                if (cordinate.piece?.getColor() == Color.WHITE){
                    if (cordinate.y == board.getBoardHeight()){
                        return Status(true , "")
                    }
                }
                if (cordinate.piece?.getColor() == Color.BLACK){
                    if (cordinate.y == 1){
                        return Status(true , "")
                    }
                }
            }
        }
        return Status(false , "You can't promote this piece")
    }
}