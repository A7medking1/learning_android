package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val firstFragment = OneFragment()
    val secondFragment = TwoFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initSubView()
        addClick()
        addNavigation()

    }


    private fun addNavigation () {
        binding.bottomNavId.setOnItemSelectedListener { item ->
         when(item.itemId){
             R.id.first -> {
                 replaceFragment(firstFragment)
                 true
             }

             R.id.two -> {
                 replaceFragment(secondFragment)
                 true
             }
             else -> false

         }
        }
    }


    private fun addClick() {
        binding.btn.setOnClickListener {
            showSecondFragment()
        }

        binding.rmBtn.setOnClickListener {
            removeFragment(secondFragment)
        }
    }

    private fun removeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.remove( fragment)
        transaction.commit()
    }

    private fun showSecondFragment() {
   //     addFragment(secondFragment)
        replaceFragment(secondFragment)
    }

    private fun initSubView() {
        addFragment(firstFragment)
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }

}