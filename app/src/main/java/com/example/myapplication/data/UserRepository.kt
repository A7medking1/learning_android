package com.example.myapplication.data

import androidx.lifecycle.LiveData

class UserRepository (private val userDao: UserDao){
    val readAllData: LiveData<List<User>> = userDao.radAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

}