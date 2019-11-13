package com.example.tibiarapv01.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestLogin {
    @SerializedName("grant_type")
    @Expose
    private String grantType;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("username")
    @Expose
    private String username;

    /**
     * No args constructor for use in serialization
     *
     */



    public RequestLogin( String  grantType, String username, String password) {
        super();
        this.grantType = grantType;
        this.password = password;
        this.username = username;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
