package edu.iesam.examaad1eval.features.ex1.feature.data

import edu.iesam.examaad1eval.features.ex1.feature.data.local.ItemXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.feature.data.local.ServicesXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.feature.data.local.UserXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.feature.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.feature.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.feature.domain.Item
import edu.iesam.examaad1eval.features.ex1.feature.domain.Services
import edu.iesam.examaad1eval.features.ex1.feature.domain.User

class DataRepository(
    private val servicesLocal: ServicesXmlLocalDataSource,
    private val itemsLocal: ItemXmlLocalDataSource,
    private val userLocal: UserXmlLocalDataSource,
    private val remote: MockEx1RemoteDataSource
) : Ex1Repository {

    override fun getUsers(): List<User> {
        val localUsers = userLocal.getUsers()

        return localUsers.ifEmpty {
            val remoteUsers = remote.getUsers()
            userLocal.saveUsers(remoteUsers)
            remoteUsers
        }
    }

    override fun getServices(): List<Services> {
        val localServices = servicesLocal.getServices()
        return localServices.ifEmpty {
            val remoteServices = remote.getServices()
            servicesLocal.saveServices(remoteServices)
            remoteServices
        }
    }

    override fun getItems(): List<Item> {
        val localItems = itemsLocal.getItems()
        return localItems.ifEmpty {
            val remoteItems = remote.getItems()
            itemsLocal.saveItems(remoteItems)
            remoteItems
        }
    }



}