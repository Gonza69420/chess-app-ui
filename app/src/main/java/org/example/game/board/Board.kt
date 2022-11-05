package org.example.game.board

class Board (private val cordinates : List<Cordinate>) {

    fun updateBoard(Cordinate1 : Cordinate, Cordinate2 : Cordinate) : Board{
        val newCordinates = cordinates.map {
            if (it.x == Cordinate1.x && it.y == Cordinate1.y) {
                Cordinate2
            } else if (it.x == Cordinate2.x && it.y == Cordinate2.y) {
                Cordinate1
            } else {
                it
            }
        }
        return Board(newCordinates)
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
            for (x in xMin + 1 until xMax) {
                for (y in yMin + 1 until yMax) {
                    if (x == y) {
                        cordinatesInBetween.add(getCordinate(x, y))
                    }
                }
            }
        }
        return cordinatesInBetween
    }

    fun getCordinate(x: Int, y: Int): Cordinate {
        return cordinates.first { it.x == x && it.y == y }
    }

}