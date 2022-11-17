import junit.framework.Assert.assertEquals
import org.example.fabric.PieceFabricator
import org.example.game.Game
import org.example.game.WinCondition
import org.example.game.board.Board
import org.example.game.board.Cordinate
import org.example.game.board.CordinateWithPiece
import org.example.game.board.EmptyCordinate
import org.example.game.piece.Color
import org.example.game.piece.Piece
import org.junit.Test

class testCheck {


    @Test
    fun whenInCheck_thenReturnTrue() {
        val pieceFabricator = PieceFabricator()
        var cordinates : List<Cordinate> = mutableListOf()
        for (i in 1..5){
            cordinates += EmptyCordinate(i,1)
            cordinates += EmptyCordinate(i,2)

        }

        for (i in 6..8){
            cordinates += EmptyCordinate(i,1)
            cordinates += EmptyCordinate(i,2)

        }
        val kingTest : Piece = pieceFabricator.createKing(5, Color.WHITE)
        val winCondition = WinCondition(listOf(kingTest))

        cordinates += CordinateWithPiece(5,1, kingTest)
        cordinates += CordinateWithPiece(5,2, pieceFabricator.createRook(6, Color.BLACK))


        val game = Game(Board(cordinates), winCondition, Color.WHITE, pieceFabricator.createQueen(1, Color.WHITE))
        assertEquals(true, game.isItCheck())
    }

    @Test
    fun whenNotInCheck_ThenReturnFalse() {
        val pieceFabricator = PieceFabricator()
        var cordinates : List<Cordinate> = mutableListOf()
        for (i in 1..5){
            cordinates += EmptyCordinate(i,1)
            cordinates += EmptyCordinate(i,2)

        }

        for (i in 6..8){
            cordinates += EmptyCordinate(i,1)
            cordinates += EmptyCordinate(i,2)

        }
        val kingTest : Piece = pieceFabricator.createKing(5, Color.WHITE)
        val winCondition = WinCondition(listOf(kingTest))

        cordinates += CordinateWithPiece(5,1, kingTest)
        cordinates += CordinateWithPiece(5,2, pieceFabricator.createBishop(6, Color.BLACK))


        val game = Game(Board(cordinates), winCondition, Color.WHITE, pieceFabricator.createQueen(1, Color.WHITE))
        assertEquals(false, game.isItCheck())
    }
}