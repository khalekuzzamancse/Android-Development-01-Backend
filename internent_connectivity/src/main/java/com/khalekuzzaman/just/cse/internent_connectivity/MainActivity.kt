package com.khalekuzzaman.just.cse.internent_connectivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import newsapi.Output
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val output=
            newsapi.Output()
        GlobalScope.launch {
            output.fetch()
        }

    }
}