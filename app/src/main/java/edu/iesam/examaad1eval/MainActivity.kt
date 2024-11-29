package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.feature.data.DataRepository
import edu.iesam.examaad1eval.features.ex1.feature.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.feature.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.core.room.DataBaseProvider
import edu.iesam.examaad1eval.features.ex2.feature.data.GamesDataRepository
import edu.iesam.examaad1eval.features.ex2.feature.data.db.GameDbDataSource
import edu.iesam.examaad1eval.features.ex2.feature.data.remote.GamesMockRemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()

    }

    private fun executeExercise1() {
        val repository = DataRepository(
            local = Ex1XmlLocalDataSource(this),
            remote = MockEx1RemoteDataSource()
        )
        repository.getUsers()
        repository.getItems()
        repository.getServices()

        Log.d("@dev", repository.getUsers().toString())
        Log.d("@dev", repository.getItems().toString())
        Log.d("@dev", repository.getServices().toString())
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        val room = GamesDataRepository(GamesMockRemoteDataSource(), GameDbDataSource(DataBaseProvider.provideDatabase(this).gameDao()))
        GlobalScope.launch(Dispatchers.IO) {
            room.getGames()

        }
    }
}