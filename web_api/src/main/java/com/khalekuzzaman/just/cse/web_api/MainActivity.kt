package com.khalekuzzaman.just.cse.web_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khalekuzzaman.just.cse.web_api.volley.MyVolley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myVolley=
            MyVolley.getInstance(this.applicationContext)
        myVolley.doJsonObjectRequest()
    }
}