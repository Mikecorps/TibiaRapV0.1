package com.example.tibiarapv01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tibiarapv01.Common.SharePreferenceManager;
import com.example.tibiarapv01.Request.RequestLogin;
import com.example.tibiarapv01.Response.ResponseLogin;
import com.example.tibiarapv01.Response.UserResponse;
import com.example.tibiarapv01.Retrofit.TibiaClient;
import com.example.tibiarapv01.Retrofit.TibiaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.*;

public class Main2Activity extends AppCompatActivity {

    TibiaService tibiaService;
    TibiaClient tibiaClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();


//        Toast.makeText(this , "aout="+token,Toast.LENGTH_LONG ).show();







    }
}
