package edu.iesam.examaad1eval.features.ex2.feature.data.remote

import edu.iesam.examaad1eval.features.ex2.feature.domain.Game
import edu.iesam.examaad1eval.features.ex2.feature.domain.Players

class GamesMockRemoteDataSource {

    fun getGames(): List<Game>{
        return listOf(
            Game("1", "Day of Tentacle", getPlayers().toString()),
            Game("2", "Monkey Island", listOf( getPlayers().first()).toString()),
            Game("4", "Comandos 1", listOf(getPlayers().last()).toString()),
            Game("5", "Comandos 2", listOf(getPlayers().last()).toString()),
            Game("6", "Comandos 3", listOf(getPlayers().last()).toString()),
            Game("7", "Comandos 4", listOf(getPlayers().last()).toString()),
            Game("8", "Comandos 5", getPlayers().toString()),
        ).shuffled()
    }

    private fun getPlayers(): List<Players>{
        return listOf(
            Players("1", "Juan"),
            Players(id = "2", name = "Pepe")
        ).shuffled()
    }


}