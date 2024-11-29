package edu.iesam.examaad1eval.features.ex1.feature.data.local

import android.content.Context
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.feature.domain.User

class UserXmlLocalDataSource(context: Context) {


    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.shared_name), Context.MODE_PRIVATE
    )

    fun getUsers(): List<User> {
        val users = mutableListOf<User>()
        users.forEach {
            sharedPref.edit().putString(it.id, it.name).apply()
        }
        return users

    }

    fun saveUsers(users: List<User>) {
        users.forEach {
            sharedPref.edit().putString(it.id, it.name).apply()
        }

    }


}

