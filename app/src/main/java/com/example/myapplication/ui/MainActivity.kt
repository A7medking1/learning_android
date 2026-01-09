package com.example.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.User
import com.example.myapplication.model.Wisdom
import com.example.myapplication.presenter.MainPresenter

class MainActivity : AppCompatActivity(), IMainView {
    lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        presenter.view = this
        presenter.fetchUserInfo()
        binding.button.setOnClickListener {
            presenter.fetchAWisdom()
        }
    }

    override fun onUserInfoSuccess(user: User) {
        binding.userName.text = user.name
    }

    override fun onWisdomSuccess(wisdom: Wisdom) {
        binding.apply {
            textDate.text = wisdom.publishDate
            content.text = wisdom.content
        }
    }


}