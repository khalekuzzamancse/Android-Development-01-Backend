package com.example.broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class DynamicReceiver extends AppCompatActivity {
    private  IntentFilter filter;
    private BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_receiver);

        //creating intentFilter
        filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        //
        receiver=(BroadcastReceiver) new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i("ActionRecevied",intent.getAction());
            }
        };
       registerReceiver(receiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
