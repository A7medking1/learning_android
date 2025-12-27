package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    lateinit var newRecycleView: RecyclerView
    private lateinit var newArray: ArrayList<Dog>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        enableEdgeToEdge()
        newArray  = ArrayList<Dog>()
        getData()
        setContentView(binding.root)

        newRecycleView = binding.recyclerView
        newRecycleView.layoutManager = LinearLayoutManager(this)
        newRecycleView.setHasFixedSize(true)

        newRecycleView.adapter = MyAdapter(newArray) { dog ->
            Toast.makeText(this, "Clicked: ${dog.title}", Toast.LENGTH_SHORT).show()
        }

    }


    private fun getData() {
        repeat(14) {
            newArray.add(
                Dog(
                    title = "Dog ${it + 1}: Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    image = R.drawable.playstore
                )
            )
        }
    }


}