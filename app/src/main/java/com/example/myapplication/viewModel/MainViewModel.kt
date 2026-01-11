package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.JokeRepository
import com.example.myapplication.model.JokeResponse
import com.example.myapplication.model.State
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    val joke = MutableLiveData<State<JokeResponse?>>()
    val errorMessage = MutableLiveData<String?>()


    val repository: JokeRepository = JokeRepository()

    init {
        getRandomJoke()
    }

    fun getRandomJoke() {
        viewModelScope.launch {
            val result = repository.getRandomJoke()
            result.collect { state ->
                when (state) {
                    is State.Loading -> joke.postValue(state)
                    is State.Success -> joke.postValue(state)
                    is State.Error -> {
                        Log.e("JokeViewModel", "Error: ${state.message}")
                        errorMessage.postValue(state.message)
                        joke.postValue(state)
                    }
                }
            }
        }
    }
}