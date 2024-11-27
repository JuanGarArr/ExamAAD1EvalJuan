package edu.iesam.examaad1eval.features.ex1.feature.data.local

import android.content.Context
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.feature.domain.Services

class ServicesXmlLocalDataSource (context: Context) {

    val sharedPref= context.getSharedPreferences(
        context.getString(R.string.shared_name), Context.MODE_PRIVATE)

    fun getServices(): List<Services>{
        val services = mutableListOf<Services>()
        services.forEach{
            sharedPref.edit().putString(it.id, it.name).apply()
        }
        return services

    }

    fun saveServices(services: List<Services>){
        services.forEach{
            sharedPref.edit().putString(it.id, it.name).apply()
        }

    }

}