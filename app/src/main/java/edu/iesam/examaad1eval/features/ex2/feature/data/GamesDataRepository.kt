package edu.iesam.examaad1eval.features.ex2.feature.data

import edu.iesam.examaad1eval.features.ex2.feature.data.db.GameDbDataSource
import edu.iesam.examaad1eval.features.ex2.feature.data.remote.GamesMockRemoteDataSource
import edu.iesam.examaad1eval.features.ex2.feature.domain.Game
import edu.iesam.examaad1eval.features.ex2.feature.domain.GamesRepository

class GamesDataRepository(
    private val remote: GamesMockRemoteDataSource,
    private val local: GameDbDataSource
) : GamesRepository {

    override fun getGames(): List<Game> {
        val localGames = local.getGames()
        if (localGames.isEmpty()) {
            val remoteGames = remote.getGames()
            local.saveGames(remoteGames)
            return remoteGames
        } else {
            return localGames
        }

    }
}