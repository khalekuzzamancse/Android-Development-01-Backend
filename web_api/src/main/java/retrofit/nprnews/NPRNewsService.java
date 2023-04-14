package retrofit.nprnews;

import retrofit.nprnews.model.Feed;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NPRNewsService {
    @GET("/1019/feed.json")
    Call<Feed> getFeed();
}
