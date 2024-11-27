package edu.iesam.examaad1eval.features.ex2.feature.data

import edu.iesam.examaad1eval.features.ex2.feature.data.remote.GamesMockRemoteDataSource
import edu.iesam.examaad1eval.features.ex2.feature.domain.Game
import edu.iesam.examaad1eval.features.ex2.feature.domain.GamesRepository

class GamesDataRepository (private val remoteDataSource: GamesMockRemoteDataSource) :
    GamesRepository {

    override fun getGames(): List<Game> {
        return remoteDataSource.getGames()

    }


}