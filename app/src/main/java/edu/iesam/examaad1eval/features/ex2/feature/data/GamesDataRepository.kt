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
        val gameList = ArrayList<Game>()
        val localGames = local.getGames()

        if (localGames.isEmpty()) {
            val remoteGames = remote.getGames()
            local.saveGames(remoteGames.take(4))
            gameList.addAll(remoteGames)
            return gameList
        } else {
            val remoteGames = remote.getGames()
            for (remoteGame in remoteGames) {
                if (!localGames.contains(remoteGame)) {
                    gameList.add(remoteGame)
                }
            }
            local.saveGames(gameList)
            return gameList

        }
    }
}