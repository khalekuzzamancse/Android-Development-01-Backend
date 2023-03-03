package com.example.sqlite_raw.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WordDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="myDatabase";
    public static final int DATABASE_VERSION=1;
    private Context context;
    public WordDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
