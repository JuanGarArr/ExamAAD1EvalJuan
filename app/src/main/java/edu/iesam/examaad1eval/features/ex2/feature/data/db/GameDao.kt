package edu.iesam.examaad1eval.features.ex2.feature.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGames(vararg games: GameEntity)

    @Query("SELECT * FROM $TABLE_NAME_GAMES")
    fun getGames(): List<GameEntity>

    @Query("DELETE FROM $TABLE_NAME_GAMES")
    fun deleteGames()
}