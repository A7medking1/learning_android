package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity.Constants.EXTRA_NAME
import com.example.myapplication.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {
    lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(MainActivity.Companion.LOG_TAG, "onCreate")

        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        binding.textView.text = "Welcome $name"

        addCallBack()
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    companion object {
        const val LOG_TAG = "SecondActivity"
    }


    private fun addCallBack() {
        binding.btnBack.setOnClickListener {
            finish()
        }

    }
}