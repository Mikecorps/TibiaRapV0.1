package com.example.tibiarapv01.UI.MenuFragments.home;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.Retrofit.TibiaClient;
import com.example.tibiarapv01.Retrofit.TibiaService;
import com.example.tibiarapv01.UI.NewsFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    TibiaService tibiaService;
    TibiaClient tibiaClient;

    private MutableLiveData<List<News>> news = new MutableLiveData<>();

    public LiveData<List<News>> getNews()
    {
        tibiaClient = TibiaClient.getInstance();
        tibiaService = tibiaClient.getService();

        Call<List<News>> call = tibiaService.getNews();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful())
                {
                    news.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

            }
        });

        return news;
    }


}