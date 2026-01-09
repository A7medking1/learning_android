package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val fakeApi = FakeApiService()
    val database = FakeDataBase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        fetchUserInfo()

        binding.button.setOnClickListener {
            fetchAWisdom()
        }
    }

    private fun fetchAWisdom() {
        val result = fakeApi.getRandomWisdom()
        binding.apply {
            textDate.text = result.publishDate
            content.text = result.content
        }
    }

    private fun fetchUserInfo() {
        val user = database.getCurrentUser()

        binding.userName.text = user.name
    }

}