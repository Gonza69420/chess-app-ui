package org.example.fabric

import org.example.game.Validator.ValidatorMove
import org.example.game.Validator.move.DiagonalValidatorMove
import org.example.game.Validator.move.HorizontalValidatorMove
import org.example.game.Validator.move.JumpValidator
import org.example.game.Validator.move.VerticalValidatorMove
import org.example.game.Validator.pieces.JuggerValidatorPiece
import org.example.game.Validator.pieces.PawnValidatorMove
import org.example.game.Validator.special.CastleValidator
import org.example.game.piece.Color
import org.example.game.piece.Piece
import org.example.game.piece.PieceWithSpecialMove
import org.example.game.piece.PieceWithoutSpecialMove

class PieceFabricator {

    fun createPawn(id : Int , color : Color) : Piece{
        val hashMap = HashMap<String , Int>()

        hashMap.put("moves", 0)
        return PieceWithoutSpecialMove(id , color , "pawn" , listOf(PawnValidatorMove()) , hashMap, false, true)
    }

    fun createRook(id : Int , color : Color) : Piece{
        val hashMap = HashMap<String , Int>()

        hashMap.put("moves", 0)
        val validators = ArrayList<ValidatorMove>()

        validators.add(VerticalValidatorMove(0 , true))
        validators.add(VerticalValidatorMove(0 , false))
        validators.add(HorizontalValidatorMove(0 , true))
        validators.add(HorizontalValidatorMove(0 , false))
        return PieceWithoutSpecialMove(id , color , "rook" , validators , hashMap)
    }

    fun createKnight(id : Int , color : Color) : Piece{
        val hashMap = HashMap<String , Int>()
        val validators = ArrayList<ValidatorMove>()

        hashMap.put("moves", 0)
        validators.add(JumpValidator(1 , 2))
        validators.add(JumpValidator(2 , 1))
        validators.add(JumpValidator(1 , -2))
        validators.add(JumpValidator(2 , -1))
        validators.add(JumpValidator(-1 , 2))
        validators.add(JumpValidator(-2 , 1))
        validators.add(JumpValidator(-1 , -2))
        validators.add(JumpValidator(-2 , -1))

        return PieceWithoutSpecialMove(id , color , "knight" , validators , hashMap)
    }

    fun createBishop(id : Int , color : Color) : Piece{
        val hashMap = HashMap<String , Int>()

        hashMap.put("moves", 0)
        val validators = ArrayList<ValidatorMove>()
        validators.add(DiagonalValidatorMove(0 , listOf(1,2,3,4)))
        return PieceWithoutSpecialMove(id , color , "bishop" , validators , hashMap)
    }

    fun createQueen(id : Int , color : Color) : Piece{
        val hashMap = HashMap<String , Int>()

        hashMap.put("moves", 0)
        val validators = ArrayList<ValidatorMove>()
        validators.add(DiagonalValidatorMove(0 , listOf(1,2,3,4)))
        validators.add(VerticalValidatorMove(0 , true))
        validators.add(VerticalValidatorMove(0 , false))
        validators.add(HorizontalValidatorMove(0 , true))
        validators.add(HorizontalValidatorMove(0 , false))
        return PieceWithoutSpecialMove(id , color , "queen" , validators , hashMap)
    }

    fun createKing(id : Int , color : Color) : Piece{
        val hashMap = HashMap<String , Int>()

        hashMap.put("moves", 0)
        val validators = ArrayList<ValidatorMove>()
        validators.add(DiagonalValidatorMove(1 , listOf(1,2,3,4)))
        validators.add(VerticalValidatorMove(1 , true))
        validators.add(VerticalValidatorMove(1 , false))
        validators.add(HorizontalValidatorMove(1 , true))
        validators.add(HorizontalValidatorMove(1 , false))
        return PieceWithSpecialMove(id , color , "king" , validators , hashMap, listOf(CastleValidator()))
    }

    fun createKingWithouthCastle(id : Int , color: Color) : Piece{
        val hashMap = HashMap<String , Int>()

        hashMap.put("moves", 0)
        hashMap.put("kills", 0)
        val validators = ArrayList<ValidatorMove>()
        validators.add(DiagonalValidatorMove(1 , listOf(1,2,3,4)))
        validators.add(VerticalValidatorMove(1 , true))
        validators.add(VerticalValidatorMove(1 , false))
        validators.add(HorizontalValidatorMove(1 , true))
        validators.add(HorizontalValidatorMove(1 , false))
        return PieceWithoutSpecialMove(id , color , "king" , validators , hashMap)
    }

    fun createJugger(id : Int , color : Color) : Piece{
        val hashMap = HashMap<String , Int>()

        hashMap.put("moves", 0)
        val validators = ArrayList<ValidatorMove>()
        validators.add(JuggerValidatorPiece())
        return PieceWithoutSpecialMove(id , color , "jugger" , validators , hashMap)
    }

}