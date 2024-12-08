package edu.iesam.examaad1eval.features.ex2.feature.data.db

import edu.iesam.examaad1eval.features.ex2.feature.domain.Game


class GameDbDataSource(private val gameDao: GameDao) {

    fun saveGames(games: List<Game>) {
        gameDao.saveGames(*games.map {
            it.toGameEntity()
        }.toTypedArray())
    }

    fun getGames(): List<Game> {
       return gameDao.getGames().map {
           it.toGame()
       }
    }

    fun delete(){
        gameDao.deleteGames()
    }

}