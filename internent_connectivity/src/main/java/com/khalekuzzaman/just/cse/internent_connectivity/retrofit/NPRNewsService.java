package com.khalekuzzaman.just.cse.internent_connectivity.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NPRNewsService {
    @GET("/1019/feed.json")
    Call<Feed> getFeed();
}
