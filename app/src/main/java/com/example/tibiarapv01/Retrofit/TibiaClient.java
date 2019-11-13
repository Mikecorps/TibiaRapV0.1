package com.example.tibiarapv01.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TibiaClient {

    private static TibiaClient instance = null;
    private  TibiaService service;
    private Retrofit retrofit;

    public TibiaClient()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://tibiadraptor.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(TibiaService.class);
    }
    public static TibiaClient getInstance()
    {
        if (instance == null)
        {
            instance = new TibiaClient();
        }
        return  instance;
    }

    public  TibiaService getService()
    {
        return service;
    }



}
