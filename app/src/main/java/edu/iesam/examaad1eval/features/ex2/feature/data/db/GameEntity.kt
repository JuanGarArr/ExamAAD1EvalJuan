package edu.iesam.examaad1eval.features.ex2.feature.data.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.examaad1eval.features.ex2.feature.domain.Players

const val TABLE_NAME_GAMES = "games"
const val GAME_ID = "id"

@Entity(tableName = TABLE_NAME_GAMES)
data class GameEntity(
    @PrimaryKey @ColumnInfo(name = GAME_ID) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "players") val players: List<Players>

)