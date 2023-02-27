package com.example.contentproivder;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AppSpecificDirInternal {
    Context context;

    public AppSpecificDirInternal(Context context) {
        this.context = context;
    }

    public void writeTextFile(String fileName, String content) {
        try (FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE)) {
            fos.write(content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void listOfAllFiles() {
      String[] list=context.fileList();
        Log.i("FileList", Arrays.toString(list));
    }
    public void readFile(String fileName) throws FileNotFoundException {
        FileInputStream fis = context.openFileInput(fileName);
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        } finally {
            String contents = stringBuilder.toString();
            Log.i("FileContent: ",contents);
        }
    }
    public void createDirectory(String directoryName){
        File rootDir = context.getFilesDir();
        Log.i("FileContent",rootDir.getName());
        File newDir = new File(rootDir, directoryName);
        try {
            newDir.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
