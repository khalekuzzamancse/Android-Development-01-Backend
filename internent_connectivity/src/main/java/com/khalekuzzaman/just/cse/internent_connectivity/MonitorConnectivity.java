package com.khalekuzzaman.just.cse.internent_connectivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;

import androidx.annotation.NonNull;

public class MonitorConnectivity {
    private boolean isConnected;
    private ConnectivityManager manager;
    private final ConnectivityManager.NetworkCallback
            networkCallback = new ConnectivityManager.NetworkCallback() {
        @Override
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
            Log.i("Connected-Network: ", String.valueOf(network));
        }


        @Override
        public void onCapabilitiesChanged(
                @NonNull Network network,
                @NonNull NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            isConnected = networkCapabilities
                    .hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED) &&
                    networkCapabilities
                            .hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
            Log.i("Connected", String.valueOf(isConnected));

        }

        @Override
        public void onLost(@NonNull Network network) {
            super.onLost(network);
            isConnected = false;
            Log.i("Connected-DisconnectedFrom: ", String.valueOf(network));
        }

    };

    public void unRegister() {
        if (manager != null) {
            manager.unregisterNetworkCallback(networkCallback);
        }
    }

}
