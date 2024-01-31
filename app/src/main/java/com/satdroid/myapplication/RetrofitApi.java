package com.satdroid.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitApi {

    @POST("users")
    Call<postDataModel> createPost(@Body postDataModel postDataModel);
}
