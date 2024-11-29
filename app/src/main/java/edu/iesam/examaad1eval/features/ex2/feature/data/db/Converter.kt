package edu.iesam.examaad1eval.features.ex2.feature.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.feature.domain.Players

class Converter {

    private val gson = Gson()

    @TypeConverter
    fun fromPlayers(players: List<Players>): String {
        return gson.toJson(players)

    }

    @TypeConverter
    fun toPlayers(json: String): List<Players> {
        return gson.fromJson(json, Array<Players>::class.java).toList()
    }

}