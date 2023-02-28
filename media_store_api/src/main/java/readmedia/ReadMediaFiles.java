package readmedia;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

public class ReadMediaFiles {
    Context context;

    public ReadMediaFiles(Context context) {
        this.context = context;

    }

    public void readImage01Version1() {
        String[] projection = {
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME
        };
        ContentResolver resolver = context.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor =
                resolver.query(uri, projection, null, null, null);

        int idColumn = cursor.getColumnIndex(MediaStore.Images.Media._ID);
        int displayNameColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME);

        Log.i("MediaStoreImages", "Count" + cursor.getCount());
        while (cursor.moveToNext()) {

            long id = cursor.getLong(idColumn);
            String displayName = cursor.getString(displayNameColumn);

            Uri contentUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id
            );
            Log.i("MediaStoreImages", displayName + "->" + contentUri + "->" + id);

        }


    }
}
