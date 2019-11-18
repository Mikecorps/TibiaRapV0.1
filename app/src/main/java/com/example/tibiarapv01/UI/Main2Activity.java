package com.example.tibiarapv01.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.Achievement;
import com.example.tibiarapv01.Response.Achievements;
import com.example.tibiarapv01.Response.UserResponse;
import com.example.tibiarapv01.Retrofit.TibiaAuthClient;
import com.example.tibiarapv01.Retrofit.TibiaAuthService;
import com.example.tibiarapv01.UI.dummy.DummyContent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity implements AchieveFragment.OnListFragmentInteractionListener{

    TibiaAuthService tibiaService;
    TibiaAuthClient tibiaClient;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        getSupportActionBar().hide();



        RefitInit();
        Call<UserResponse> call = tibiaService.getUserData();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful())
                {
                    getSupportActionBar().setTitle(response.body().getData().getUsername());


                }else{
                    Toast.makeText(Main2Activity.this, "Error de peticion", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });


    }


    private void RefitInit() {
        tibiaClient = TibiaAuthClient.getInstance();
        tibiaService = tibiaClient.getAuthService();
    }


    @Override
    public void onListFragmentInteraction(Achievement item) {

    }
}
