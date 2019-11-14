package com.example.tibiarapv01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tibiarapv01.Common.SharePreferenceManager;
import com.example.tibiarapv01.Request.RequestLogin;
import com.example.tibiarapv01.Response.ResponseLogin;
import com.example.tibiarapv01.Response.UserResponse;
import com.example.tibiarapv01.Retrofit.TibiaAuthClient;
import com.example.tibiarapv01.Retrofit.TibiaAuthService;
import com.example.tibiarapv01.Retrofit.TibiaClient;
import com.example.tibiarapv01.Retrofit.TibiaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.widget.Toast.*;

public class Main2Activity extends AppCompatActivity {

    TibiaAuthService tibiaService;
    TibiaAuthClient tibiaClient;
    TextView username, email,id_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        getSupportActionBar().hide();

        username = findViewById(R.id.textViewUsername);
        email = findViewById(R.id.textViewEmal);
        id_user = findViewById(R.id.textViewID);

        RefitInit();
        Call<UserResponse> call = tibiaService.getUserData();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful())
                {
                    getSupportActionBar().setTitle(response.body().getData().getUsername());
                    username.setText( "username: "+response.body().getData().getUsername());
                    email.setText("Email. "+response.body().getData().getEmail());
                    id_user.setText("ID: "+response.body().getData().getId().toString());


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

}
