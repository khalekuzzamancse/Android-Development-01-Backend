package com.example.contentproivder;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AppSpecificDirExternal {
    Context context;

    public AppSpecificDirExternal(Context context) {
        this.context = context;
    }

    public void writeTextFile(String fileName, String content) {
        File[] externalStorageVolumes =
                ContextCompat.getExternalFilesDirs(context, null);
        File rootDir = externalStorageVolumes[0];

        try (FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE)) {
            fos.write(content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
            Log.i("FileContent: ", contents);
        }
    }

    public void createDirectory(String directoryName) {
        File[] externalStorageVolumes =
                ContextCompat.getExternalFilesDirs(context, null);
        File rootDir = externalStorageVolumes[0];

        File newDir = new File(rootDir, directoryName);
        try {
            newDir.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllDir() {
        File[] externalStorageVolumes =
                ContextCompat.getExternalFilesDirs(context, null);
        File primaryExternalStorage = externalStorageVolumes[0];
        Log.i("PrimaryStorageName", primaryExternalStorage.getName());
    }


    public File getAlbumStorageDir(String albumName) {
        File file = new File(context.getExternalFilesDir(
                Environment.DIRECTORY_PICTURES), albumName);
        if (file == null || !file.mkdirs()) {
            Log.i("PictureDirectoryName", "Directory not created");
        }

        return file;
    }

}
