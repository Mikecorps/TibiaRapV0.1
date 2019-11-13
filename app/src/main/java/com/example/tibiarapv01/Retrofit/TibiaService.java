package com.example.tibiarapv01.Retrofit;

import com.example.tibiarapv01.Request.RequestLogin;
import com.example.tibiarapv01.Response.ResponseLogin;
import com.example.tibiarapv01.Request.RequestCreateAccount;


import retrofit2.Call;
import retrofit2.http.Body;
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





}
