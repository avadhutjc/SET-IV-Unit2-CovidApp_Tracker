package com.masai.setiv_2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/v1/us/daily/{userId}")
    Call<ResponseModel> getUser(@Path("userId") int userId);
    Call<List<ResponseModel>> getPosts(String postId);
}