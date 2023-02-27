package com.example.contentproivder;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.UserDictionary;
import android.util.Log;

import java.util.Locale;

public class UserDictionaryProvider {
    Context context;

   public UserDictionaryProvider(Context context) {
        this.context = context;
    }

    public void getWords() {
        Uri dicUri= UserDictionary.Words.CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();
        String[] projection = {
                UserDictionary.Words._ID,
                UserDictionary.Words.WORD,
                UserDictionary.Words.LOCALE

        };
        Cursor cursor = contentResolver.query(dicUri, projection, null, null, null);
        Log.i("WordFetched", " : "+cursor.getCount());
        while (cursor.moveToNext()) {
            int Id = cursor.getColumnIndex( UserDictionary.Words.WORD);
            String word = cursor.getString(Id);
            Log.i("WordFetched", " : " + word);
        }
    }
    public void insertWord(){
        Uri dicUri= UserDictionary.Words.CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();

        final Locale locale;
        locale = Locale.getDefault();
        final int COLUMN_COUNT = 3;
        ContentValues values = new ContentValues(COLUMN_COUNT);
        values.put(UserDictionary.Words.WORD, "Quasimodo");
        values.put(UserDictionary.Words.FREQUENCY, 250);
        values.put(UserDictionary.Words.LOCALE, locale.toString());

       // Uri result = contentResolver.insert(UserDictionary.Words.CONTENT_URI, values);

//        ContentValues newValues=new ContentValues();
//        newValues.put(UserDictionary.Words.APP_ID, "com.example.contentproivder");
//        newValues.put(UserDictionary.Words.LOCALE, "en_US");
//        newValues.put(UserDictionary.Words.WORD, "insert");
//        newValues.put(UserDictionary.Words.FREQUENCY, "10");
        Uri newUri= contentResolver.insert(dicUri,values);
        if (newUri!=null)
            Log.i("Inserted","Successfully");
        else
            Log.i("Inserted","Failed");
    }

}
