package org.example

import edu.austral.dissis.chess.gui.*
import org.example.fabric.GameFabricator
import org.example.game.piece.Color

class GameEngineClassic  : GameEngine {

    var game = GameFabricator().createClassicGame()

    override fun applyMove(move: Move): MoveResult {
        try {
            if (game.isItCheckMate()) {
                if (game.getTurn() == Color.WHITE) {
                    return GameOver(PlayerColor.WHITE)
                }else{
                    return GameOver(PlayerColor.BLACK)
                }
            }
            game = game.movePiece(move.from.column, move.from.row, move.to.column, move.to.row)
            if  (game.getTurn() == Color.WHITE) {
                return NewGameState(chessPieces() , PlayerColor.WHITE)
            }else{
                return NewGameState(chessPieces() , PlayerColor.BLACK)
            }
        }catch (e : Exception){
            return InvalidMove( e.message.toString())
        }
    }

    override fun init(): InitialState {
        return InitialState(BoardSize(game.getBoard().getBoardWidth(), game.getBoard().getBoardHeight()), chessPieces(), PlayerColor.WHITE)
    }

    fun chessPieces(): List<ChessPiece>{
        val listChessPieces = ArrayList<ChessPiece>()
        for (i in game.getBoard().getAllPieces()){
                val cordinate = game.getBoard().getCordinateByPieceId(i.id)
                if (i.color == Color.WHITE){
                    listChessPieces.add(ChessPiece(i.id.toString(), PlayerColor.WHITE , Position(cordinate.y , cordinate.x), i.type.toString()))
                }else{
                    listChessPieces.add(ChessPiece(i.id.toString(), PlayerColor.BLACK , Position(cordinate.y , cordinate.x), i.type.toString()))
                }
        }
        return listChessPieces
    }
}