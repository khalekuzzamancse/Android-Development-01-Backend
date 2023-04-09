package com.khalekuzzaman.just.cse.internent_connectivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khalekuzzaman.just.cse.internent_connectivity.retrofit.Output
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val output=Output()
        GlobalScope.launch {
            output.fetch()
        }

    }
}