package org.example.game.board

class Board (val cordinates : List<Cordinate>) {

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
        if(Cordinate1.x == Cordinate2.x){
            val yRange = if(Cordinate1.y > Cordinate2.y){
                Cordinate2.y..Cordinate1.y
            }else{
                Cordinate1.y..Cordinate2.y
            }
            for(y in yRange){
                if(y != Cordinate1.y && y != Cordinate2.y){
                    cordinatesInBetween.add(getCordinate(Cordinate1.x, y))
                }
            }
        }else if(Cordinate1.y == Cordinate2.y){
            val xRange = if(Cordinate1.x > Cordinate2.x){
                Cordinate2.x..Cordinate1.x
            }else{
                Cordinate1.x..Cordinate2.x
            }
            for(x in xRange){
                if(x != Cordinate1.x && x != Cordinate2.x){
                    cordinatesInBetween.add(getCordinate(x, Cordinate1.y))
                }
            }
        }
        return cordinatesInBetween
    }

    private fun getCordinate(x: Int, y: Int): Cordinate {
        return cordinates.first { it.x == x && it.y == y }
    }

}