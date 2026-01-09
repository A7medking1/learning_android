package com.example.myapplication.presenter

import com.example.myapplication.FakeApiService
import com.example.myapplication.FakeDataBase
import com.example.myapplication.ui.IMainView

class MainPresenter {
    private val fakeApi = FakeApiService()
    private val database = FakeDataBase()
    lateinit var view: IMainView

    fun fetchUserInfo() {
        val user = database.getCurrentUser()
        view.onUserInfoSuccess(user)
    }

    fun fetchAWisdom() {
        val result = fakeApi.getRandomWisdom()
        view.onWisdomSuccess(result)
    }

}