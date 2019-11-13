package com.example.tibiarapv01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.tibiarapv01.Common.SharePreferenceManager;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        String token  = SharePreferenceManager.getAppSettingsFile("PREF_TOKEN");
        Toast.makeText(this , "aout="+token,Toast.LENGTH_LONG ).show();

    }
}
