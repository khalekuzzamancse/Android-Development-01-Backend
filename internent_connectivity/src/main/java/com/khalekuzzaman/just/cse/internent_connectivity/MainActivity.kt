package com.khalekuzzaman.just.cse.internent_connectivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khalekuzzaman.just.cse.internent_connectivity.retrofit.newsapi.Output
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val output=
            Output()
        GlobalScope.launch {
            output.fetch()
        }

    }
}