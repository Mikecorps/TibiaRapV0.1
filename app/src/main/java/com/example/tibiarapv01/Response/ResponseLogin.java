package com.example.tibiarapv01.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {


    @SerializedName("success")
    @Expose
    private String success;
    public ResponseLogin() {
    }

    public ResponseLogin(String success) {
        super();
        this.success = success;
    }
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
