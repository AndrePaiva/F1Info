package com.andrepaiva.f1info.data.model.ApiEntities.tables;

import com.andrepaiva.f1info.data.model.ApiEntities.Constructor;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andrepaiva on 21/05/17.
 */

public class ConstructorTable {

    public ConstructorTable() {
    }

    public ConstructorTable(String season, List<Constructor> constructors) {
        this.season = season;
        this.constructors = constructors;
    }

    @SerializedName("season")
    private String season;

    @SerializedName("Constructors")
    private List<Constructor> constructors;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public ConstructorTable withSeason(String season) {
        this.season = season;
        return this;
    }

    public List<Constructor> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
    }

    public ConstructorTable withConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
        return this;
    }
}
