package com.example.tibiarapv01.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Achievements {

    @SerializedName("data")
    @Expose
    private List<Achievement> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Achievements() {
    }

    /**
     *
     * @param data
     */
    public Achievements(List<Achievement> data) {
        super();
        this.data = data;
    }

    public List<Achievement> getData() {
        return data;
    }

    public void setData(List<Achievement> data) {
        this.data = data;
    }

}
