package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        foo()
    }

    private fun foo() {
//        val list = listOf<Int>(1,2,3,5,5,5,4,6,7,8,9,2,5,2)
        val observable = Observable.interval(1, TimeUnit.SECONDS).map { it * 2 }


        observable.subscribe{ t ->
                Log.d(TAG, "onNext: $t")
            binding.result.text = t.toString()
            }



//        val observer = object : Observer<Int> {
//            override fun onSubscribe(d: Disposable) {
//                Log.d(TAG, "onSubscribe: ")
//            }
//
//            override fun onNext(t: Int) {
//                Log.d(TAG, "onNext: $t")
//            }
//
//            override fun onError(e: Throwable) {
//                Log.d(TAG, "onError: $e")
//            }
//
//            override fun onComplete() {
//                Log.d(TAG, "onComplete")
//            }
//
//        }
//
//        happy.subscribe(observer)

    }


    companion object {
        private const val TAG = "MAKE_REQUEST_TAK"
    }


}