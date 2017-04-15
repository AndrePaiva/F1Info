package com.andrepaiva.f1info.data.model.ApiEntities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time_ {

    @SerializedName("time")
    @Expose
    private String time;

    /**
     * No args constructor for use in serialization
     *
     */
    public Time_() {
    }

    /**
     *
     * @param time
     */
    public Time_(String time) {
        super();
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}


