package com.example.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        enableEdgeToEdge()
        setContentView(binding.root)
        initForms()

        onTapButton()
    }


    private fun onTapButton() {
        binding.butonLogin.setOnClickListener {
            onClick()
        }
    }

    private fun onClick() {
        val sharedPrefs: SharedPreferences = getSharedPreferences("test", MODE_PRIVATE)
        val edit = sharedPrefs.edit()

        val userName = binding.userName.editText?.text.toString()
        val password = binding.password.editText?.text.toString()

        edit.putString("userName", userName)
        edit.putString("password", password)

        edit.apply()

        Toast.makeText(this, "Login Successful! Welcome $userName", Toast.LENGTH_SHORT).show()
    }


    private fun initForms() {
        val sharedPrefs: SharedPreferences = getSharedPreferences("test", MODE_PRIVATE)

        val userName = sharedPrefs.getString("userName", "")
        val password = sharedPrefs.getString("password", "")

        if (!userName.isNullOrEmpty()) {
            binding.userName.editText?.setText(userName)
        }
        if (!password.isNullOrEmpty()) {
            binding.password.editText?.setText(password)
        }




    }


}