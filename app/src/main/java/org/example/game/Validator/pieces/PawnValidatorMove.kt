package org.example.game.Validator.pieces

import org.example.game.Validator.GeneralValidator
import org.example.game.Validator.Status
import org.example.game.Validator.ValidatorMove
import org.example.game.Validator.move.HorizontalValidatorMove
import org.example.game.Validator.move.PawnCaptureValidatorMove
import org.example.game.Validator.move.VerticalValidatorMove
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.piece.Color

class PawnValidatorMove() : ValidatorMove {
    private val generalValidator = GeneralValidator()
    private val pawnCaptureValidatorMove: PawnCaptureValidatorMove = PawnCaptureValidatorMove()
    private lateinit var verticalValidatorMove : VerticalValidatorMove

    override fun validate(Cordinate1: Cordinate, Cordinate2: Cordinate, color: Color, board: Board): Status {
        if (pawnCaptureValidatorMove.validate(Cordinate1, Cordinate2, color, board).bool) {
            return Status(true, "")
        }
        if (color == Color.WHITE) {
            verticalValidatorMove = VerticalValidatorMove(1, false)
        } else {
            verticalValidatorMove = VerticalValidatorMove(1, true)
        }
        if (verticalValidatorMove.validate(Cordinate1, Cordinate2, color, board).bool && !Cordinate2.hasPiece()) {
            return Status(true, "")
        }
        if (generalValidator.validateIsItMyPiece(Cordinate1, color).bool) {
            if (generalValidator.validateAllyPieceInSecondCordinate(Cordinate2, color).bool) {
                if (generalValidator.validateCordinate1EqualsCordinate2(
                        Cordinate1,
                        Cordinate2
                    ).bool
                ) {
                    if (generalValidator.validatePiecesInBetween(
                            Cordinate1,
                            Cordinate2,
                            board
                        ).bool
                    ) {
                        if (Cordinate1.piece?.data?.get("moves") == 0 && !Cordinate2.hasPiece()) {
                            if (Cordinate1.x == Cordinate2.x && Cordinate1.y == Cordinate2.y - 2 && color == Color.WHITE) {
                                return Status(true, "")
                            }
                            if (Cordinate1.x == Cordinate2.x && Cordinate1.y == Cordinate2.y + 2 && color == Color.BLACK) {
                                return Status(true, "")
                            }
                        }
                    }
                }
            }
        }
        return Status(false, "Invalid move")
    }
}