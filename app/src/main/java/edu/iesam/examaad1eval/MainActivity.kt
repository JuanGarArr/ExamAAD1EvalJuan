package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.feature.data.DataRepository
import edu.iesam.examaad1eval.features.ex1.feature.data.local.ItemXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.feature.data.local.ServicesXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.feature.data.local.UserXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.feature.data.remote.MockEx1RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
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
            userLocal = UserXmlLocalDataSource(this),
            itemsLocal = ItemXmlLocalDataSource(this),
            servicesLocal = ServicesXmlLocalDataSource(this),
            remote = MockEx1RemoteDataSource()
        )
        repository.getUsers()
        repository.getItems()
        repository.getServices()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            //llamar a Room
        }
    }
}