package removemedia;


import android.app.Activity;
import android.app.PendingIntent;
import android.app.RecoverableSecurityException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;

import com.example.media_store_api.CallbackModify;
import com.example.media_store_api.MainActivity;
import com.example.media_store_api.MainActivity2;

import java.util.ArrayList;
import java.util.List;

public class RemoveMediaFile {
    Context context;


    public RemoveMediaFile(Context context) {
        this.context = context;

    }


    public void deleteImageAPI30(Uri uri,ActivityResultLauncher<IntentSenderRequest> deleteResultLauncher) {
        ContentResolver contentResolver = context.getContentResolver();
       List<Uri> arrayList2 = new ArrayList();
        arrayList2.add(uri);
        IntentSender intentSender = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            intentSender = MediaStore.createDeleteRequest(contentResolver, arrayList2).getIntentSender();
            IntentSenderRequest senderRequest = new IntentSenderRequest.Builder(intentSender)
                    .setFillInIntent(null)
                    .setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION, 0)
                    .build();
            deleteResultLauncher.launch(senderRequest);
        }
    }




    }

