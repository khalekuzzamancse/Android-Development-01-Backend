package com.khalekuzzaman.just.cse.web_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit.josnplaceholderapi.PostFetcher
import retrofit.nprnews.Output

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            PostFetcher().getPost(1,2)
        }


    }
}