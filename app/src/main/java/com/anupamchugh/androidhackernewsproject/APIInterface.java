package com.anupamchugh.androidhackernewsproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface APIInterface {

    @GET("topstories.json?print=pretty")
    Call<List<Integer>> doGetPostId();
}

