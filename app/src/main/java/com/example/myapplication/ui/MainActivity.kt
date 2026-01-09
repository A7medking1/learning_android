package com.example.myapplication.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }


    private fun setup() {
        viewModel.fetchUserInfo()
        binding.button.setOnClickListener {
            viewModel.fetchAWisdom()
        }

        viewModel.currentUser.observe(this) {
            binding.userName.text = it.name
        }

        viewModel.currentWisdom.observe(this) {
            binding.apply {
                textDate.text = it.publishDate
                content.text = it.content
            }
        }
    }


}