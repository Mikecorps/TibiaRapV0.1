package com.example.tibiarapv01.UI.MenuFragments.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tibiarapv01.Response.Achievement;
import com.example.tibiarapv01.Response.Achievements;
import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.Retrofit.TibiaAuthClient;
import com.example.tibiarapv01.Retrofit.TibiaAuthService;
import com.example.tibiarapv01.Retrofit.TibiaClient;
import com.example.tibiarapv01.Retrofit.TibiaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardViewModel extends ViewModel {


    TibiaAuthService tibiaService;
    TibiaAuthClient tibiaClient;
    private MutableLiveData<List<Achievement>> achievement = new MutableLiveData<>();
    private Achievements achievements = new Achievements();
    public DashboardViewModel() {

    }

  public LiveData<List<Achievement>> getAchievements(){

        tibiaClient = TibiaAuthClient.getInstance();
        tibiaService = tibiaClient.getAuthService();

      Call<Achievements> call = tibiaService.getAllAchievements();
      call.enqueue(new Callback<Achievements>() {
          @Override
          public void onResponse(Call<Achievements> call, Response<Achievements> response) {
              if (response.isSuccessful()){
                  achievement.setValue( response.body().getData());
              }
          }
          @Override
          public void onFailure(Call<Achievements> call, Throwable t) {

          }
      });




        return  achievement;
    }
}