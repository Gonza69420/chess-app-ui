package org.example.game.board

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer
import org.example.game.piece.Color
import org.example.game.piece.Piece
import java.lang.Math.abs

class Board (private var cordinates : List<Cordinate> ) {

    fun updateBoard(Cordinate1 : Cordinate, Cordinate2 : Cordinate) : Board{
        val mutableCordinates = mutableListOf<Cordinate>()
        for (i in cordinates){
            if (i.x == Cordinate1.x && i.y == Cordinate1.y){
                mutableCordinates.add(i.pieceDeparture())
                continue
            }
            if (i.x == Cordinate2.x && i.y == Cordinate2.y){
                mutableCordinates.add(i.pieceArrival(Cordinate1.piece!!))
                continue
            }
            mutableCordinates.add(i)
        }
        return Board(mutableCordinates)
    }

    fun getCordinatesInBetween(Cordinate1 : Cordinate, Cordinate2 : Cordinate) : List<Cordinate>{
        val cordinatesInBetween = mutableListOf<Cordinate>()
        val x1 = Cordinate1.x
        val y1 = Cordinate1.y
        val x2 = Cordinate2.x
        val y2 = Cordinate2.y
        if (x1 == x2) {
            val yMin = minOf(y1, y2)
            val yMax = maxOf(y1, y2)
            for (y in yMin + 1 until yMax) {
                cordinatesInBetween.add(getCordinate(x1, y))
            }
        } else if (y1 == y2) {
            val xMin = minOf(x1, x2)
            val xMax = maxOf(x1, x2)
            for (x in xMin + 1 until xMax) {
                cordinatesInBetween.add(getCordinate(x, y1))
            }
        }else{
            val xMin = minOf(x1, x2)
            val xMax = maxOf(x1, x2)
            val yMin = minOf(y1, y2)
            val yMax = maxOf(y1, y2)
            for (x in xMin + 1 until xMax){
                for (y in yMin + 1 until yMax){
                    if (Math.abs(x - x1) == Math.abs(y - y1)){
                        cordinatesInBetween.add(getCordinate(x , y))
                    }
                }
            }
        }
        return cordinatesInBetween
    }



    fun getCordinate(x: Int, y: Int): Cordinate {
        return cordinates.first { it.x == x && it.y == y }
    }

    fun getIdOfPiecesInBoard () : List<Int>{
        val idOfPieces = mutableListOf<Int>()
        cordinates.forEach {
            if (it.hasPiece()){
                idOfPieces.add(it.piece!!.id)
            }
        }
        return idOfPieces
    }

    fun getEnemyCordinates (color : Color) : List<Cordinate>{
        val enemyPieces = mutableListOf<Cordinate>()
        cordinates.forEach {
            if (it.hasPiece()){
                if (it.piece!!.color != color){
                    enemyPieces.add(it)
                }
            }
        }
        return enemyPieces
    }

    fun getAllyCordinates (color : Color) : List<Cordinate>{
        val allyPieces = mutableListOf<Cordinate>()
        cordinates.forEach {
            if (it.hasPiece()){
                if (it.piece!!.color == color){
                    allyPieces.add(it)
                }
            }
        }
        return allyPieces
    }

    fun getCordinateByPieceId (id : Int) : Cordinate {
        for (i in cordinates){
            if (i.hasPiece()){
                if (i.piece!!.id == id){
                    return i
                }
            }
        }
        throw Exception("No piece with id $id")
    }

    fun getCordinates() : List<Cordinate> {
        return cordinates
    }

    fun getBoardWidth() : Int {
        return cordinates.map { it.x }.max()!!
    }

    fun getBoardHeight() : Int {
        return cordinates.map { it.y }.max()!!
    }

    fun getAllPieces() : List<Piece> {
        val pieces = mutableListOf<Piece>()
        cordinates.forEach {
            if (it.hasPiece()){
                pieces.add(it.piece!!)
            }
        }
        return pieces
    }
}