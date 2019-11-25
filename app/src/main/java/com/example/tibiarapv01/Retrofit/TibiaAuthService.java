package com.example.tibiarapv01.Retrofit;


import com.example.tibiarapv01.Request.RequestAcMarc;
import com.example.tibiarapv01.Response.Achievements;
import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.Response.UserResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface TibiaAuthService {


    @GET("user")
    Call<UserResponse> getUserData();

    @POST("achievements")
    Call<Achievements> getAllAchievements();

    @GET("news")
    Call<List<News>> getNews();

    @PATCH("achievements")
    Call<UserResponse> marcAchieve(@Body RequestAcMarc acMarc);

}
