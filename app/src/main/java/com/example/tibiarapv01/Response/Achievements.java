package com.example.tibiarapv01.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Achievements {
    @SerializedName("data")
    @Expose
    private List<Achievement> data = null;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("total")
    @Expose
    private Integer total;

    /**
     * No args constructor for use in serialization
     *
     */
    public Achievements() {
    }

    /**
     *
     * @param total
     * @param data
     * @param meta
     * @param links
     */
    public Achievements(List<Achievement> data, Links links, Meta meta, Integer total) {
        super();
        this.data = data;
        this.links = links;
        this.meta = meta;
        this.total = total;
    }

    public List<Achievement> getData() {
        return data;
    }

    public void setData(List<Achievement> data) {
        this.data = data;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
