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
        val gameList = mutableListOf<Game>()
        val user = local.getGames()

        user.forEach {
            gameList.add(it)
        }

        val games = remote.getGames()
        games.forEach {
            if (gameList.size < 7) {
                gameList.add(it)
            }
        }

        return gameList

    }
}