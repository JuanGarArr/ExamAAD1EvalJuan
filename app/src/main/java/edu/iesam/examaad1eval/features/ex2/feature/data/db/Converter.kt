package edu.iesam.examaad1eval.features.ex2.feature.data.db

import androidx.room.TypeConverter

class Converter {

    @TypeConverter
    fun fromGameEntity(gameEntity: GameEntity): String {
        return "${gameEntity.id},${gameEntity.title},${gameEntity.players}"

    }

    @TypeConverter
    fun toGameEntity(gameString: String): GameEntity {
        return GameEntity(
            id = gameString.split(",")[0],
            title = gameString.split(",")[1],
            players = gameString.split(",")[2]
        )

    }
}