package retrofit.josnplaceholderapi.api;

import android.widget.LinearLayout;

import java.util.List;

import retrofit.josnplaceholderapi.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostService {
    @GET("/posts")
    Call<List<Post>> getPost();
    @GET("/posts/{id}")
    Call<Post> getPost(@Path("id") String id);

    @GET("/posts")
    Call<List<Post>> getPost(@Query("_page") Integer page, @Query("_limit") Integer limit);

}
