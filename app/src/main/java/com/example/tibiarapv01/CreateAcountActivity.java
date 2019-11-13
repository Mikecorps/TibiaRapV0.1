package com.example.tibiarapv01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tibiarapv01.Request.RequestCreateAccount;
import com.example.tibiarapv01.Response.ResponseLogin;
import com.example.tibiarapv01.Retrofit.TibiaClient;
import com.example.tibiarapv01.Retrofit.TibiaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAcountActivity extends AppCompatActivity {

    TextView username;
    TextView email;
    TextView password;
    TibiaService tibiaService;
    TibiaClient tibiaClient;
    Button btn_create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acount);
        getSupportActionBar().hide();

        username = findViewById(R.id.Account_user);
        email    = findViewById(R.id.Account_email);
        password = findViewById(R.id.Account_pass);
        btn_create = findViewById(R.id.btn_create);
        RefitInit();

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              final String usern, mail, pass;
              usern = username.getText().toString();
              mail  = email.getText().toString();
              pass  = password.getText().toString();
              if (usern.isEmpty())
              {
                  username.setError("Campo requerido");

              }else if(mail.isEmpty()){
                  email.setError("Campo Requerido");
              }
              else if(pass.isEmpty()){
                  password.setError("Campo Requerido");
              }
              else{
                  RequestCreateAccount requestCreateAccount = new RequestCreateAccount(mail,pass,usern);
                  Call<ResponseLogin> call = tibiaService.CreateAccount(requestCreateAccount);
                  call.enqueue(new Callback<ResponseLogin>() {
                      @Override
                      public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                          if (response.isSuccessful() ) {
                              Toast.makeText(CreateAcountActivity.this, "Sesion Iniciada", Toast.LENGTH_LONG);
                              Intent intent = new Intent(CreateAcountActivity.this, Main2Activity.class);
                              startActivity(intent);
                              finish();
                          }
                      }
                      @Override
                      public void onFailure(Call<ResponseLogin> call, Throwable t) {

                      }
                  });
              }
            }
        });





    }


    private void RefitInit() {
        tibiaClient = TibiaClient.getInstance();
        tibiaService = tibiaClient.getService();
    }

}
