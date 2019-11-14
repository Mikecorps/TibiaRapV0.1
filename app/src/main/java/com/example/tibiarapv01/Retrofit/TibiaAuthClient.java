package com.example.tibiarapv01.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TibiaAuthClient {

    private static TibiaAuthClient instance = null;
    private  TibiaAuthService service;
    private Retrofit retrofit;

    public TibiaAuthClient()
    {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new AuthInterceptor());

        OkHttpClient client = okHttpClient.build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://tibiadraptor.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        service = retrofit.create(TibiaAuthService.class);
    }
    public static TibiaAuthClient getInstance()
    {
        if (instance == null)
        {
            instance = new TibiaAuthClient();
        }
        return  instance;
    }

    public  TibiaAuthService getAuthService ()
    {
        return service;
    }



}
