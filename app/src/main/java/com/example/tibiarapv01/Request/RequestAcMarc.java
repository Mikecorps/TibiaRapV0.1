package com.example.tibiarapv01.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestAcMarc {
    @SerializedName("id")
    @Expose
    private int id;

    public RequestAcMarc( int  id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
