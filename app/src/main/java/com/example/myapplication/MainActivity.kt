package com.example.myapplication

import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private lateinit var client: OkHttpClient  // Declare but don't initialize

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        client = OkHttpClient()


        setContentView(binding.root)

        binding.btn.setOnClickListener {
            makeRequestUsingOkHttpWithQueryParams(binding.name.text.toString())
        }
    }
    private fun makeRequestUsingOkHttpWithQueryParams(name: String) {


         var url = HttpUrl.Builder()
            .scheme("https")
            .host("api.nationalize.io")
            .addQueryParameter("name",name)
            .build()

        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(
            object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d(TAG, "onFailure : ${e.message}")
                }
                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread {
                        binding.result.text = response.body?.string()
                    }
                }
            },
        )
    }


    private fun makeRequestUsingOkHttp() {
        val request = Request.Builder().url("https://v2.jokeapi.dev/joke/Any").build()

        client.newCall(request).enqueue(
            object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d(TAG, "onFailure : ${e.message}")
                }
                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread {
                        binding.result.text = response.body?.string()
                    }
                }
            },
        )
    }

    companion object {
        private const val TAG = "MAKE_REQUEST_TAK"
    }


    private fun makeRequest() {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)


        val uri = URL("https://v2.jokeapi.dev/joke/Any")

        val connections = uri.openConnection()
        val inputStream = connections.getInputStream()
        val inputStreamReader = InputStreamReader(inputStream)

        val result = inputStreamReader.readText()
        binding.result.text = result


    }


}