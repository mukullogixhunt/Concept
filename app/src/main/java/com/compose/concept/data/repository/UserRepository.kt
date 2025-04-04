package com.compose.concept.data.repository

import com.compose.concept.data.local.dao.UserDao
import com.compose.concept.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    val allUsers: Flow<List<UserEntity>> = userDao.getAllUSer()

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteALlAUsers()
    }

}