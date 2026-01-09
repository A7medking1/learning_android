package com.example.myapplication.presenter

import com.example.myapplication.repository.MainRepository
import com.example.myapplication.ui.IMainView

class MainPresenter {
    lateinit var view: IMainView

    private val repository = MainRepository()

    fun fetchUserInfo() {
        val user = repository.fetchUserInfo()
        view.onUserInfoSuccess(user)
    }

    fun fetchAWisdom() {
        val result = repository.fetchAWisdom()
        view.onWisdomSuccess(result)
    }

}