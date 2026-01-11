package com.example.myapplication

import com.example.myapplication.model.JokeResponse
import com.example.myapplication.model.State
import com.example.myapplication.networking.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokeRepository {
    fun getRandomJoke(): Flow<State<JokeResponse?>> {
        return flow {
            emit(State.Loading)
            try {
                val resalt = Api.apiService.getRandomJoke()
                if (resalt.isSuccessful) {
                    emit(State.Success(resalt.body()))
                } else {
                    emit(State.Error(resalt.message()))
                }
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }

        }
    }
}