package edu.iesam.examaad1eval.features.ex2.core.room

import android.content.Context
import androidx.room.Room

object DataBaseProvider {

    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }
}