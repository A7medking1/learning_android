package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.User
import com.example.myapplication.data.UserDao

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.radAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

}