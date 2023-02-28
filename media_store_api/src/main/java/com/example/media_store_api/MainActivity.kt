package com.example.media_store_api

import android.app.Activity
import android.app.RecoverableSecurityException
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startIntentSenderForResult
import readmedia.ReadMediaFiles

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val read = ReadMediaFiles(this)
//        read.readImage01Version1()
//        val remove=RemoveMediaFile(this)
//        val uri=Uri.parse("content://media/external/images/media/5801");
//        remove.removeImage01Version1(uri)


    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 100) {

        }
    }


}
