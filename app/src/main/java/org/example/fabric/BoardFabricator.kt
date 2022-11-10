package org.example.fabric

import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.CordinateWithPiece
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color

class BoardFabricator {
    val PieceFabricator = PieceFabricator()
    fun createNormalBoard() : Board {
        var listCordinates : List<Cordinate> = mutableListOf()

        listCordinates += CordinateWithPiece(1,1,PieceFabricator.createRook(1,Color.WHITE))
        listCordinates += CordinateWithPiece(2,1,PieceFabricator.createKnight(2,Color.WHITE))
        listCordinates += CordinateWithPiece(3,1,PieceFabricator.createBishop(3,Color.WHITE))
        listCordinates += CordinateWithPiece(4,1,PieceFabricator.createQueen(4,Color.WHITE))
        listCordinates += CordinateWithPiece(5,1,PieceFabricator.createKing(5,Color.WHITE))
        listCordinates += CordinateWithPiece(6,1,PieceFabricator.createBishop(6,Color.WHITE))
        listCordinates += CordinateWithPiece(7,1,PieceFabricator.createKnight(7,Color.WHITE))
        listCordinates += CordinateWithPiece(8,1,PieceFabricator.createRook(8,Color.WHITE))
        for (i in 1..8){
            listCordinates += CordinateWithPiece(i,2,PieceFabricator.createPawn(i+8,Color.WHITE))
        }

        for (i in 1..8){
            for (j in 3..6){
                listCordinates += EmptyCordinate(i,j)
            }
        }

        for (i in 1..8){
            listCordinates += CordinateWithPiece(i,7,PieceFabricator.createPawn(i+16,Color.BLACK))
        }

        listCordinates += CordinateWithPiece(1,8,PieceFabricator.createRook(25,Color.BLACK))
        listCordinates += CordinateWithPiece(2,8,PieceFabricator.createKnight(26,Color.BLACK))
        listCordinates += CordinateWithPiece(3,8,PieceFabricator.createBishop(27,Color.BLACK))
        listCordinates += CordinateWithPiece(4,8,PieceFabricator.createQueen(28,Color.BLACK))
        listCordinates += CordinateWithPiece(5,8,PieceFabricator.createKing(29,Color.BLACK))
        listCordinates += CordinateWithPiece(6,8,PieceFabricator.createBishop(30,Color.BLACK))
        listCordinates += CordinateWithPiece(7,8,PieceFabricator.createKnight(31,Color.BLACK))
        listCordinates += CordinateWithPiece(8,8,PieceFabricator.createRook(32,Color.BLACK))

        return Board(listCordinates)
    }

    fun createAntiChessBoard() : Board{
        var listCordinates : List<Cordinate> = mutableListOf()

        listCordinates += CordinateWithPiece(1,1,PieceFabricator.createRook(1,Color.WHITE))
        listCordinates += CordinateWithPiece(2,1,PieceFabricator.createKnight(2,Color.WHITE))
        listCordinates += CordinateWithPiece(3,1,PieceFabricator.createBishop(3,Color.WHITE))
        listCordinates += CordinateWithPiece(4,1,PieceFabricator.createQueen(4,Color.WHITE))
        listCordinates += CordinateWithPiece(5,1,PieceFabricator.createKingWithouthCastle(5,Color.WHITE))
        listCordinates += CordinateWithPiece(6,1,PieceFabricator.createBishop(6,Color.WHITE))
        listCordinates += CordinateWithPiece(7,1,PieceFabricator.createKnight(7,Color.WHITE))
        listCordinates += CordinateWithPiece(8,1,PieceFabricator.createRook(8,Color.WHITE))
        for (i in 1..8){
            listCordinates += CordinateWithPiece(i,2,PieceFabricator.createPawn(i+8,Color.WHITE))
        }

        for (i in 1..8){
            for (j in 3..6){
                listCordinates += EmptyCordinate(i,j)
            }
        }

        for (i in 1..8){
            listCordinates += CordinateWithPiece(i,7,PieceFabricator.createPawn(i+16,Color.BLACK))
        }

        listCordinates += CordinateWithPiece(1,8,PieceFabricator.createRook(25,Color.BLACK))
        listCordinates += CordinateWithPiece(2,8,PieceFabricator.createKnight(26,Color.BLACK))
        listCordinates += CordinateWithPiece(3,8,PieceFabricator.createBishop(27,Color.BLACK))
        listCordinates += CordinateWithPiece(4,8,PieceFabricator.createQueen(28,Color.BLACK))
        listCordinates += CordinateWithPiece(5,8,PieceFabricator.createKingWithouthCastle(29,Color.BLACK))
        listCordinates += CordinateWithPiece(6,8,PieceFabricator.createBishop(30,Color.BLACK))
        listCordinates += CordinateWithPiece(7,8,PieceFabricator.createKnight(31,Color.BLACK))
        listCordinates += CordinateWithPiece(8,8,PieceFabricator.createRook(32,Color.BLACK))

        return Board(listCordinates)
    }
}