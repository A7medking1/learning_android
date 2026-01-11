package com.example.myapplication.networking

import com.example.myapplication.model.JokeResponse
import retrofit2.Response
import retrofit2.http.GET

interface JokeApiService {
    @GET("joke/Any")
    suspend fun getRandomJoke(): Response<JokeResponse>
}