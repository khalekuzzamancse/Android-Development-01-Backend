package com.example.document_and_file_picker;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button openPicker=findViewById(R.id.btn_open);
//        openPicker.setOnClickListener(view->{
//
//
//        });

        ActivityResultLauncher<Intent> resultLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result!=null){
                            Intent replyIntent=result.getData();
                            Uri uri=replyIntent.getData();
                            Log.i("createdFileUri", DocumentsContract.Document.COLUMN_FLAGS);

                        }
                    }
                });

       // Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        intent.setType("application/pdf");
//        intent.putExtra(Intent.EXTRA_TITLE, "Testing.pdf");
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
        resultLauncher.launch(intent);
    }


}









