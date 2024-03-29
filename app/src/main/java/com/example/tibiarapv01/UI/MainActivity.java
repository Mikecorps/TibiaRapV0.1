package com.example.tibiarapv01.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tibiarapv01.Common.SharePreferenceManager;
import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Request.RequestLogin;
import com.example.tibiarapv01.Response.Achievements;
import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.Response.ResponseLogin;
import com.example.tibiarapv01.Retrofit.TibiaClient;
import com.example.tibiarapv01.Retrofit.TibiaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {


    Button binLogan;
    EditText UserAccount,  Password;
    TextView Create_account;
    TibiaService tibiaService;
    TibiaClient tibiaClient;
    Achievements achievements;
    List<News> news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        binLogan = findViewById(R.id.Btn_login);
        UserAccount = findViewById(R.id.id_user);
        Password = findViewById(R.id.ET_pass);
        Create_account = findViewById(R.id.Create_account);

        RefitInit();





        binLogan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String user,pass;
                Call<List<News>> CN = tibiaService.getNews();
                CN.enqueue(new Callback<List<News>>() {
                    @Override
                    public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                        if (response.isSuccessful())
                        {
                            news = response.body();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<News>> call, Throwable t) {

                    }
                });

               user = UserAccount.getText().toString();
               pass = Password.getText().toString();

               if (user.isEmpty()  ){
                   UserAccount.setError("Complete todos los campos");
                }
               else if ( pass.isEmpty() ) {
                   Password.setError("Complete Todos los campos");
               }
               else
               {
                   RequestLogin requestLogin = new RequestLogin("password", user, pass);
                   Call<ResponseLogin> call = tibiaService.doLogin(requestLogin);
                   call.enqueue(new Callback<ResponseLogin>() {
                       @Override
                       public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                           if (response.isSuccessful() ) {
                               Log.d("Response code:", "===========" + response.body().getToken()  );
                                SharePreferenceManager.setAppSettingsFile("PREF_TOKEN",response.body().getToken());

                               Toast.makeText(MainActivity.this, "Sesion Iniciada", Toast.LENGTH_LONG).show();
                               Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                               startActivity(intent);
                               finish();
                           }
                           else{

                               UserAccount.setError("Usuario y/o contraseña incorrectos");

                           }
                       }

                       @Override
                       public void onFailure(Call<ResponseLogin> call, Throwable t) {

                       }
                   });
               }

            }
        });

        Create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAcountActivity.class);
                startActivity(intent);

            }
        });




    }


    private void RefitInit() {
        tibiaClient = TibiaClient.getInstance();
        tibiaService = tibiaClient.getService();
    }



}
