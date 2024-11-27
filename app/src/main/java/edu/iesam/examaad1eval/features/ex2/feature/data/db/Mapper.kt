package edu.iesam.examaad1eval.features.ex2.feature.data.db

import edu.iesam.examaad1eval.features.ex2.feature.domain.Game

fun GameEntity.toGame(): Game {
    return Game(
        id = id,
        title = title,
        players = players
    )
}

fun Game.toGameEntity(): GameEntity {
    return GameEntity(
        id = id,
        title = title,
        players = players
    )
}