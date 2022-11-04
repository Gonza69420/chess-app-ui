package org.example.game.Validator

import org.example.game.board.EmptyCordinate

interface SpecialValidatorMove : ValidatorMove {
    val positionsInitial : List<EmptyCordinate>
    val positionFinal : List<EmptyCordinate>

}
