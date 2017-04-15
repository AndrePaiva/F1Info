package com.andrepaiva.f1info.data.model.ApiEntities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AverageSpeed {

    @SerializedName("units")
    @Expose
    private String units;
    @SerializedName("speed")
    @Expose
    private String speed;

    /**
     * No args constructor for use in serialization
     *
     */
    public AverageSpeed() {
    }

    /**
     *
     * @param speed
     * @param units
     */
    public AverageSpeed(String units, String speed) {
        super();
        this.units = units;
        this.speed = speed;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

}
