package com.khalekuzzaman.just.cse.pdf_genarate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;

import viewtopdf.ViewToPdfDocument;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(R.id.layout);
                writePdfDocumentToAppSpecificStorage(new ViewToPdfDocument().getPdfDocument(view));
            }
        });

    }
    void writePdfDocumentToAppSpecificStorage(PdfDocument document) {
        try {
            FileOutputStream fos = openFileOutput("ddd.pdf", Context.MODE_PRIVATE);
            document.writeTo(fos);
            fos.close();
            document.close();
        } catch (Exception e) {

        }
    }
}