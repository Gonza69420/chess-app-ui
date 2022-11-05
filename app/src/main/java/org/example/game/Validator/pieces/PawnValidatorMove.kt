package org.example.game.Validator.pieces

import org.example.game.Validator.ValidatorMove
import org.example.game.Validator.move.HorizontalValidatorMove
import org.example.game.Validator.move.PawnCaptureValidatorMove
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class PawnValidatorMove(
    val PawnCaptureValidatorMove: PawnCaptureValidatorMove,
    val HorizontalValidatorMove: HorizontalValidatorMove,
) : ValidatorMove {

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Boolean {
        if (PawnCaptureValidatorMove.validate(Cordinate1, Cordinate2, color, board)) {
            return true
        }
        if (HorizontalValidatorMove.validate(Cordinate1, Cordinate2, color, board)) {
            return true
        }
        if (HorizontalValidatorMove.generalValidator.validateIsItMyPiece(Cordinate1, color)) {
            if (HorizontalValidatorMove.generalValidator.validateAllyPieceInSecondCordinate(
                    Cordinate2,
                    color
                ) && HorizontalValidatorMove.generalValidator.validateCordinate1EqualsCordinate2(
                    Cordinate1,
                    Cordinate2
                ) && HorizontalValidatorMove.generalValidator.validatePiecesInBetween(
                    Cordinate1,
                    Cordinate2,
                    board
                )
            ) {
                if (Cordinate1.piece?.data?.get("moves") == Integer(0)) {
                    if (Cordinate1.x == Cordinate2.x && Cordinate1.y == Cordinate2.y + 2 && color == Color.WHITE) {
                        return true
                    }
                    if (Cordinate1.x == Cordinate2.x && Cordinate1.y == Cordinate2.y - 2 && color == Color.BLACK) {
                        return true
                    }
                }
            }
        }
        return false
    }
}