package com.anupamchugh.androidhackernewsproject;

import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("topstories.json?print=pretty")
    Call<List<Long>> getAllPostId();

    @GET("item/{id}.json?print=pretty")
    Call<ResponseBody> getPost(@Path("id") long id);
}

