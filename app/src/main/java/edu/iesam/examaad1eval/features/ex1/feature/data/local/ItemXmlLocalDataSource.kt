package edu.iesam.examaad1eval.features.ex1.feature.data.local

import android.content.Context
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.feature.domain.Item

class ItemXmlLocalDataSource (context: Context) {

    val sharedPref= context.getSharedPreferences(
        context.getString(R.string.shared_name), Context.MODE_PRIVATE)

     fun getItems(): List<Item>{
         val users = mutableListOf<Item>()
         users.forEach{
             sharedPref.edit().putString(it.id, it.name).apply()
         }
        return users
    }

     fun saveItems(items: List<Item>) {
        items.forEach {
            sharedPref.edit().putString(it.id, it.name).apply()
        }
    }


}