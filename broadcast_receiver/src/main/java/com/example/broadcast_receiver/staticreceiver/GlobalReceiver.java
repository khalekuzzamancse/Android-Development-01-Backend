package com.example.broadcast_receiver.staticreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class GlobalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      //  Log.i("BroadcastReceived",intent.getAction());
    }
}
