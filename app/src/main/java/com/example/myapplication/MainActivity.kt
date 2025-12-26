package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {


    lateinit var buttonClick: Button
    lateinit var switchUsername: SwitchMaterial
    lateinit var textUsername: EditText
    lateinit var txtTitle: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initView()
        addCallBacks()

    }


    private fun addCallBacks() {
        switchUsername.setOnCheckedChangeListener { compoundButton, b ->
            Log.i("callTag", "Button compoundButton $b")

            buttonClick.isEnabled = b
        }

        textUsername.addTextChangedListener { text ->
            Log.v("callTag", "Button text $text")
        }

        buttonClick.setOnClickListener {
//            showMessage()
            updateTitle()
        }
    }

    private fun showMessage() {
        val msg = textUsername.text.toString()
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun updateTitle() {
//        txtTitle.text = getString(R.string.enter_your_info)

        val black = ContextCompat.getColor(this, R.color.white)
        txtTitle.setTextColor(black)
    }

    private fun initView() {
        buttonClick = findViewById(R.id.btnSubmit)
        switchUsername = findViewById(R.id.switch_username)
        textUsername = findViewById(R.id.text_username)
        txtTitle = findViewById(R.id.txtTitle)

    }

}