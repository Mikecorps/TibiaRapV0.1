package com.example.tibiarapv01.Retrofit;

import com.example.tibiarapv01.Response.Achievements;
import com.example.tibiarapv01.Response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TibiaAuthService {


    @GET("user")
    Call<UserResponse> getUserData();

    @GET("achievements")
    Call<List<Achievements>> getAllAchievements();

}
