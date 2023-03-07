package com.example.room_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import worddatabase.ui.OutputOnMainThreadActivity;
import worddatabase_using_architecture.ui.OutputOnBackgroundThread;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // startActivity(new Intent(this, OutputOnMainThreadActivity.class));
        startActivity(new Intent(this, OutputOnBackgroundThread.class));

    }
}