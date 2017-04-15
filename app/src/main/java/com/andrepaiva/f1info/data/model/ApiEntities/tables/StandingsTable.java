package com.andrepaiva.f1info.data.model.ApiEntities.tables;

import java.util.List;

import com.andrepaiva.f1info.data.model.ApiEntities.StandingsList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StandingsTable {

    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("StandingsLists")
    @Expose
    private List<StandingsList> standingsLists = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public StandingsTable() {
    }

    /**
     *
     * @param season
     * @param standingsLists
     */
    public StandingsTable(String season, List<StandingsList> standingsLists) {
        super();
        this.season = season;
        this.standingsLists = standingsLists;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<StandingsList> getStandingsLists() {
        return standingsLists;
    }

    public void setStandingsLists(List<StandingsList> standingsLists) {
        this.standingsLists = standingsLists;
    }

}
