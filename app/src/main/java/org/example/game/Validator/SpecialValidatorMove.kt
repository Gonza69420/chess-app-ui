package org.example.game.Validator

import org.example.game.board.Cordinate

interface SpecialValidatorMove : ValidatorMove {
    val positionsInitial : List<Cordinate>
    val positionFinal : List<Cordinate>

}
