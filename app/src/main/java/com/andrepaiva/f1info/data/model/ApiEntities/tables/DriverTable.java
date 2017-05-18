package com.andrepaiva.f1info.data.model.ApiEntities.tables;

import com.andrepaiva.f1info.data.model.ApiEntities.Driver;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andre on 18/05/2017.
 */

public class DriverTable {

    public DriverTable() {
    }

    public DriverTable(String season, List<Driver> drivers) {
        this.season = season;
        this.drivers = drivers;
    }

    @SerializedName("season")
    private String season;

    @SerializedName("Drivers")

    private List<Driver> drivers;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
