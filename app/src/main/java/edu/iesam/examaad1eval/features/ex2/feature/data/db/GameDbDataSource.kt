package edu.iesam.examaad1eval.features.ex2.feature.data.db


class GameDbDataSource (private val gameDao: GameDao){
    fun saveGames(games: List<GameEntity>){
        gameDao.saveGames(*games.toTypedArray())
    }
    fun getGames(): List<GameEntity>{
        return gameDao.getGames()
    }

}