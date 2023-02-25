package com.example.contentproivder;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

public class FetchContact {
    Context context;
    FetchContact(Context context) {
        this.context = context;
    }

    public void getContact() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();
        String[] projection = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
        };

        Cursor cursor = contentResolver.query(uri, projection, null, null, null);
        while (cursor.moveToNext()) {
            int nameColumnId = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String name = cursor.getString(nameColumnId);
            int numberColumnId = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String number = cursor.getString(numberColumnId);
            Log.i("ContactFetched",name+" : "+number);
        }

    }
}
