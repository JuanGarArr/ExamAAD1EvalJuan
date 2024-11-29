package edu.iesam.examaad1eval.features.ex1.feature.data

import edu.iesam.examaad1eval.features.ex1.feature.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.feature.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.feature.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.feature.domain.Item
import edu.iesam.examaad1eval.features.ex1.feature.domain.Services
import edu.iesam.examaad1eval.features.ex1.feature.domain.User

class DataRepository(
    private val local: Ex1XmlLocalDataSource,
    private val remote: MockEx1RemoteDataSource
) : Ex1Repository {

    override fun getUsers(): List<User> {
        val localUsers = local.getUsers()
        if(localUsers.isEmpty()){
            val remoteUsers = remote.getUsers()
            local.saveUsers(remoteUsers)
            return remoteUsers
        }else{
            return localUsers
        }
    }

    override fun getServices(): List<Services> {
        val localServices = local.getServices()
        if(localServices.isEmpty()){
            val remoteServices = remote.getServices()
            local.saveServices(remoteServices)
            return remoteServices
        }else{
            return localServices
        }
    }

    override fun getItems(): List<Item> {
        val localItems = local.getItems()
        if(localItems.isEmpty()){
            val remoteItems = remote.getItems()
            local.saveItems(remoteItems)
            return remoteItems
        }else{
            return localItems
        }
    }



}