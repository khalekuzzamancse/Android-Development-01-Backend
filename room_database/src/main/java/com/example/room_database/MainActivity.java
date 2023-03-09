package com.example.room_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import movie_database.MovieScreen01;
import worddatabase_using_architecture.ui.OutputActivity3;
import worddatabase_using_architecture.ui.OutputActivity4;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // startActivity(new Intent(this, OutputOnMainThreadActivity.class));
        //  startActivity(new Intent(this, OutputActivity4.class));
        startActivity(new Intent(this, MovieScreen01.class));

    }
}