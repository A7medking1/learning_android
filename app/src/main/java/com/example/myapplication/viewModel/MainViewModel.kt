package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MyColors

class MainViewModel : ViewModel() {

    val loading = MutableLiveData<Boolean>(true)

    fun stopLoading(){
        if(loading.value == true){
            loading.postValue(false)
        }else {
            loading.postValue(true)
        }

    }

}