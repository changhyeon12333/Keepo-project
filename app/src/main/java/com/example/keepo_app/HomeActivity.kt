package com.example.keepo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar!!.hide()
    }
}