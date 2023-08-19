package com.example.lifecycleapp

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val ACTIVITY_NAME = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d(ACTIVITY_NAME, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ACTIVITY_NAME, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ACTIVITY_NAME, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ACTIVITY_NAME, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ACTIVITY_NAME, "onDestroy")
    }



}
