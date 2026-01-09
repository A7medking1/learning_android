package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.MainViewModel
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    
    // Data Binding instance
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        
        // Initialize data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setup()
    }


    private fun setup() {
        viewModel.fetchUserInfo()
        binding.button.setOnClickListener {
            viewModel.fetchAWisdom()
        }

//        viewModel.currentUser.observe(this) {
//            binding.userName.text = it.name
//        }

//        viewModel.currentWisdom.observe(this) {
//            binding.apply {
//                textDate.text = it.publishDate
//                content.text = it.content
//            }
//        }
    }


}