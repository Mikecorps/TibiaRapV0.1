package com.example.tibiarapv01.Retrofit;


import com.example.tibiarapv01.Request.RequestLogin;
import com.example.tibiarapv01.Response.Achievement;
import com.example.tibiarapv01.Response.Achievements;
import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.Response.ResponseLogin;
import com.example.tibiarapv01.Request.RequestCreateAccount;
import com.example.tibiarapv01.Response.UserResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TibiaService {

    @Headers({
            "content-type:application/json",
            "X-Requested-With:XMLHttpRequest"
    })

    @POST("oauth/token")
    Call<ResponseLogin> doLogin(@Body RequestLogin requestLogin);




    @Headers({
            "content-type:application/json",
            "X-Requested-With:XMLHttpRequest"
    })
    @POST("register")
    Call<ResponseLogin> CreateAccount(@Body  RequestCreateAccount requestAccount );

    @Headers({
            "content-type:application/json",
            "X-Requested-With:XMLHttpRequest"
    })
    @GET("news")
    Call<List<News>> getNews( );

    @Headers({
            "content-type:application/json",
            "X-Requested-With:XMLHttpRequest"
    })
    @POST("achievements")
    Call<Achievements> getAchiev( );












}
