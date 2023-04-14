package retrofit.josnplaceholderapi;


import android.util.Log;

import java.util.List;

import retrofit.josnplaceholderapi.api.PostService;
import retrofit.josnplaceholderapi.model.Post;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostFetcher {
    private PostService service;

    public PostFetcher() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PostService.class);
    }

    public void getPosts() {
        //Get the post
        try {
            Call<List<Post>> postCall = service.getPost();
            Response<List<Post>> response = postCall.execute();
            List<Post> post = response.body();
            Log.i("DataFected", post.toString());

        } catch (Exception ignored) {

        }
    }

    public void getPost(String id) {
        //Get the post
        try {
            Call<Post> postCall = service.getPost(id);
            Response<Post> response = postCall.execute();
            Post post = response.body();
            Log.i("DataFected", post.toString());

        } catch (Exception ignored) {

        }
    }
    public void getPost(Integer page,Integer limit) {
        //Get the post
        try {
            Call<List<Post>> postCall = service.getPost(page,limit);
            Response<List<Post>> response = postCall.execute();
            List<Post> post = response.body();
            Log.i("DataFected", post.toString());
        } catch (Exception ignored) {

        }
    }

}