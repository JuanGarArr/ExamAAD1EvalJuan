package edu.iesam.examaad1eval.features.ex2.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.feature.data.db.Converter
import edu.iesam.examaad1eval.features.ex2.feature.data.db.GameDao
import edu.iesam.examaad1eval.features.ex2.feature.data.db.GameEntity

@Database(entities = [GameEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}