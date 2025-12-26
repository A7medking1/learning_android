package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        loadImage()
    }

    private fun loadImage () {
        val url = "https://tse2.mm.bing.net/th/id/OIP.0gYQF_95CNP0mil3zXeaBQHaE8?rs=1&pid=ImgDetMain&o=7&rm=3"
        Glide.with(this).load(url)
            .placeholder(R.drawable.download)
            .error(R.drawable.info)
            .into(binding.imgView)
    }


}