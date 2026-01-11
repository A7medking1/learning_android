package com.example.myapplication.networking

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Api {
    private val BASE_URL = "https://v2.jokeapi.dev/"


    private val loggingInterceptor = HttpLoggingInterceptor { message ->
        Log.d(
            "API_INTERCEPTOR",
            message
        )
    }.apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    //joke/Any
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(JokeApiService::class.java)
}