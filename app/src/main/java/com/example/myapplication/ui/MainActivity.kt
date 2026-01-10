package com.example.myapplication.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import viewModel.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = true


    }


    companion object {
        private val TAG = "AhmedNasr"
    }
}