package retrofit.nprnews;

import android.util.Log;

import retrofit.nprnews.model.Feed;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Output {
    public void fetch() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://feeds.npr.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NPRNewsService service = retrofit.create(NPRNewsService.class);
        //Get the news Feed
        try {
            Call<Feed> feedCall = service.getFeed();
            Response<Feed> response = feedCall.execute();
            Feed feed = response.body();
            Log.i("DataFected", feed.toString());

        } catch (Exception ignored) {

        }

    }
}
