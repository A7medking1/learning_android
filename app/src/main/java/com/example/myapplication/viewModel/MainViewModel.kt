package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MyColors

class MainViewModel : ViewModel() {

    val color = MutableLiveData<MyColors>()

    fun changeData(){
        color.postValue(MyColors.entries.toTypedArray().random())
    }

}