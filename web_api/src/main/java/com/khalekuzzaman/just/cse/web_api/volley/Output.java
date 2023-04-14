package com.khalekuzzaman.just.cse.web_api.volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Output {
    private Context context;
    private RequestQueue queue;
    private Request request;
    private Response.Listener responseListener = new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            Log.i("RESPONSE_GET", response.toString());
        }
    };
    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

    public Output(Context context) {
        this.context = context;
        queue = Volley.newRequestQueue(context);
    }

    public void doStringRequest() {
        request = new
                StringRequest(Request.Method.GET, "Htjjjj", responseListener, errorListener);
        queue.add(request);

    }

    public void stopRequest() {
        if (queue != null)
            queue.stop();
    }
}
