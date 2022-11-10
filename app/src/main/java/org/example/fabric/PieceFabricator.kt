package org.example.fabric

import org.example.game.Validator.ValidatorMove
import org.example.game.Validator.move.DiagonalValidatorMove
import org.example.game.Validator.move.HorizontalValidatorMove
import org.example.game.Validator.move.VerticalValidatorMove
import org.example.game.Validator.pieces.KnightValidatorMove
import org.example.game.Validator.pieces.PawnValidatorMove
import org.example.game.Validator.special.CastleValidator
import org.example.game.WinCondition
import org.example.game.piece.Color
import org.example.game.piece.Piece
import org.example.game.piece.PieceWithSpecialMove
import org.example.game.piece.PieceWithoutSpecialMove

class PieceFabricator {

    fun createPawn(id : Int , color : Color) : Piece{
        val hashMap = HashMap<String , Int>()

        hashMap.put("moves", 0)
        return PieceWithoutSpecialMove(id , color , "pawn" , listOf(PawnValidatorMove()) , hashMap)
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

        hashMap.put("moves", 0)
        return PieceWithoutSpecialMove(id , color , "knight" , listOf(KnightValidatorMove()) , hashMap)
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

}