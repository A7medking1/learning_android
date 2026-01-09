package com.example.myapplication.repository

import com.example.myapplication.FakeApiService
import com.example.myapplication.FakeDataBase

class MainRepository {
    private val fakeApi = FakeApiService()
    private val database = FakeDataBase()


    fun fetchUserInfo() = database.getCurrentUser()

    fun fetchAWisdom() = fakeApi.getRandomWisdom()

}