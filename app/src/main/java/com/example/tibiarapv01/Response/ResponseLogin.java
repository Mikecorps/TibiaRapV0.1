package com.example.tibiarapv01.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Header;

public class ResponseLogin {



    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("token")
    @Expose
    private String token;

    public ResponseLogin() {
    }

    public ResponseLogin(String message, String token ) {
        super();
        this.message = message;
        this.token   = token;
    }
    public String getSuccess() {
        return message;
    }

    public void setSuccess(String success) {
        this.message = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }





}
