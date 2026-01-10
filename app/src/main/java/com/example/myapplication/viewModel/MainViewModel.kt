package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Api
import com.example.myapplication.model.JokeResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class MainViewModel : ViewModel() {

    val joke = MutableLiveData<JokeResponse>()

    init {
        getRandomJoke()
    }

     fun getRandomJoke() {
        Api.apiService.getRandomJoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    joke.postValue(it)
                }, {
                    Log.e("AHmednasr", it.message.toString())
                }
            )
    }
}