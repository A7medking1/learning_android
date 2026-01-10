package com.example.myapplication

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["myColors"])
fun setMyColors(view: View , myColor: MyColors?) {
    when(myColor) {
        MyColors.RED -> view.setBackgroundColor(ContextCompat.getColor(view.context,R.color.red))
        MyColors.Yellow -> view.setBackgroundColor(ContextCompat.getColor(view.context,R.color.yellow))
        MyColors.Blue ->  view.setBackgroundColor(ContextCompat.getColor(view.context,R.color.blue))
        else -> {}
    }
}