package com.example.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var smsList: ArrayList<SMS>
    private lateinit var adapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        enableEdgeToEdge()

        smsList = ArrayList<SMS>()

        setContentView(binding.root)
        setupRecyclerView()
        checkSmsPermission()
//        getSms()
    }

    private fun setupRecyclerView() {
        adapter = MyAdapter(smsList) { sms ->

        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == SMS_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                getSms()
            } else {
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun getSms() {
        try {
            val uri = Uri.parse("content://sms/inbox")
            val projection = arrayOf(SMS_SENDER, SMS_BODY, SMS_DATE)

            val cursor: Cursor? = contentResolver.query(
                uri,
                projection,
                null,
                null,
                "$SMS_DATE DESC"
            )

            cursor?.use {
                Log.i(LOG_TAG, "Total SMS: ${it.count}")
                smsList.clear()

                while (it.moveToNext()) {
                    val sender = it.getString(it.getColumnIndexOrThrow(SMS_SENDER))
                    val body = it.getString(it.getColumnIndexOrThrow(SMS_BODY))
                    val date = it.getLong(it.getColumnIndexOrThrow(SMS_DATE))

                    smsList.add(SMS(sender, body, date))
                }

                adapter.notifyDataSetChanged()
            }

        } catch (e: Exception) {
            Log.e(LOG_TAG, "Error: ${e.message}")
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }


    private fun checkSmsPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_SMS),
                SMS_PERMISSION_CODE
            )
        } else {
            getSms()
        }
    }

    companion object {
        private const val LOG_TAG = "MAIN_ACTIVITY"
        private const val SMS_BODY = "body"
        private const val SMS_SENDER = "address"
        private const val SMS_DATE = "date"
        private const val SMS_PERMISSION_CODE = 100

    }
}