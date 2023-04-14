package volley;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyRequest extends Request<MyResponse> {
    private Response.Listener<MyResponse> listener;

    public MyRequest(int method,
                     String url,
                     @Nullable Response.Listener<MyResponse> responseListener,
                     @Nullable Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        //it is mandatory to call the parent constructor first
        this.listener = responseListener;
    }

    @Override
    protected Response<MyResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            String charset = HttpHeaderParser.parseCharset(response.headers, "utf-8");
            String jsonAsString = new String(response.data, charset);
            Gson gson = new Gson();
            MyResponse obj = gson.fromJson(jsonAsString, MyResponse.class);
            return Response.success(obj, null);
        } catch (Exception exception) {
            return Response.error(new ParseError(exception));
        }
    }

    @Override
    protected void deliverResponse(MyResponse response) {
        if(listener!=null)
        {
            listener.onResponse(response);
        }
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        LinkedHashMap<String,String> param=new LinkedHashMap<>();
        //put the data
        return param;
    }
}
