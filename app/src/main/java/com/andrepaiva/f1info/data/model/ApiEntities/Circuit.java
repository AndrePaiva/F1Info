package com.andrepaiva.f1info.data.model.ApiEntities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Circuit {

    @SerializedName("circuitId")
    @Expose
    private String circuitId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("circuitName")
    @Expose
    private String circuitName;
    @SerializedName("Location")
    @Expose
    private Location location;

    /**
     * No args constructor for use in serialization
     */
    public Circuit() {
    }

    /**
     * @param location
     * @param circuitId
     * @param circuitName
     * @param url
     */
    public Circuit(String circuitId, String url, String circuitName, Location location) {
        super();
        this.circuitId = circuitId;
        this.url = url;
        this.circuitName = circuitName;
        this.location = location;
    }

    public String getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(String circuitId) {
        this.circuitId = circuitId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}