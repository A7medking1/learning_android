package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.User
import com.example.myapplication.model.Wisdom
import com.example.myapplication.repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    val currentUser = MutableLiveData<User>()
    val currentWisdom = MutableLiveData<Wisdom>()

    fun fetchUserInfo() {
        currentUser.postValue(repository.fetchUserInfo())
    }

    fun fetchAWisdom() {
        currentWisdom.postValue(repository.fetchAWisdom())
    }
}