package volley;

import androidx.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class MyAPIRequest extends Request<CustomAPIResponse> {
    private Response.Listener<CustomAPIResponse> listener;

    public MyAPIRequest(int method,
                        String url,
                        @Nullable Response.Listener<CustomAPIResponse> responseListener,
                        @Nullable Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        //it is mandatory to call the parent constructor first
        this.listener = responseListener;
    }

    @Override
    protected Response<CustomAPIResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            String charset = HttpHeaderParser.parseCharset(response.headers, "utf-8");
            String jsonAsString = new String(response.data, charset);
            Gson gson = new Gson();
            CustomAPIResponse obj = gson.fromJson(jsonAsString, CustomAPIResponse.class);
            return Response.success(obj, null);
        } catch (Exception exception) {
            return Response.error(new ParseError(exception));
        }
    }

    @Override
    protected void deliverResponse(CustomAPIResponse response) {
        if(listener!=null)
        {
            listener.onResponse(response);
        }
    }

}
