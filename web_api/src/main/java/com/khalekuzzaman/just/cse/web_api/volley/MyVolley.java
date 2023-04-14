package com.khalekuzzaman.just.cse.web_api.volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MyVolley {
    private static MyVolley instance;
    private Context context;
    private final RequestQueue queue;
    private Request request;
    private final Response.Listener responseListener = new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            Log.i("RESPONSE_GET", response.toString());
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.i("RESPONSE_GET", "Error");
        }
    };

    private MyVolley(Context context) {
        this.context = context;
        queue = Volley.newRequestQueue(context);
    }

    public static synchronized MyVolley getInstance(Context context) {
        if (instance == null) {
            instance = new MyVolley(context);
        }
        return instance;
    }

    public void doStringRequest() {
        request = new
                StringRequest(Request.Method.GET, "https://feeds.npr.org/1019/feed.json",
                responseListener, errorListener);
        queue.add(request);

    }

    public void doJsonObjectRequest() {
        //defining the callback with lambda
        Response.Listener<JSONObject> onResponse = res -> {
            Log.i("RESPONSE_GET_JOSONOBJECT", res.toString());
        };
        Response.ErrorListener onError = error -> {
            Log.i("RESPONSE_GET_JOSONOBJECT", "Error");
        };
        final String URL = "https://feeds.npr.org/1019/feed.json";
        //
        request =
                new JsonObjectRequest
                        (Request.Method.GET, URL, null,
                                onResponse, onError);
        queue.add(request);
    }

    public void stopRequest() {
        if (queue != null)
            queue.stop();
    }

    public void cancelARequest() {
        if (request != null)
            request.cancel();
    }

}
