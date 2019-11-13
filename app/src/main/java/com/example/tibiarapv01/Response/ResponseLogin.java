package com.example.tibiarapv01.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {


    @SerializedName("message")
    @Expose
    private String message;
    public ResponseLogin() {
    }

    public ResponseLogin(String message) {
        super();
        this.message = message;
    }
    public String getSuccess() {
        return message;
    }

    public void setSuccess(String success) {
        this.message = success;
    }

}
