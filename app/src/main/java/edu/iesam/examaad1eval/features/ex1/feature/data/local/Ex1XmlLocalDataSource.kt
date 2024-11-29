package edu.iesam.examaad1eval.features.ex1.feature.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.feature.domain.Item
import edu.iesam.examaad1eval.features.ex1.feature.domain.Services
import edu.iesam.examaad1eval.features.ex1.feature.domain.User

class Ex1XmlLocalDataSource(context: Context) {


    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.shared_name), Context.MODE_PRIVATE
    )

    val gson = Gson()

    fun getUsers(): List<User> {
        val users = mutableListOf<User>()
        sharedPref.all.filter {
            it.key.startsWith("user_")
        }.forEach{
            users.add(gson.fromJson(it.value as String, User::class.java))
        }
        return users

    }

    fun saveUsers(users: List<User>) {
        users.forEach {
            sharedPref.edit().putString("user"+it.id,gson.toJson(it)).apply()
        }

    }

    fun getServices(): List<Services>{
        val services = mutableListOf<Services>()
        sharedPref.all.filter {
            it.key.startsWith("service_")
        }.forEach{
            services.add(gson.fromJson(it.value as String, Services::class.java))
        }
        return services

    }

    fun saveServices(services: List<Services>){
        services.forEach{
            sharedPref.edit().putString("service_${it.id}", gson.toJson(it)).apply()
        }

    }

    fun getItems(): List<Item>{
        val items = mutableListOf<Item>()
        sharedPref.all.filter {
            it.key.startsWith("item_")
        }.forEach{
            items.add(gson.fromJson(it.value as String, Item::class.java))
        }
        return items
    }

    fun saveItems(items: List<Item>) {
        items.forEach {
            sharedPref.edit().putString("item" + it.id, gson.toJson(it)).apply()
        }
    }


}

