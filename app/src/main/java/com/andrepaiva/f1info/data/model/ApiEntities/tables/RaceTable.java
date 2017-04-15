package com.andrepaiva.f1info.data.model.ApiEntities.tables;

import java.util.List;

import com.andrepaiva.f1info.data.model.ApiEntities.Race;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RaceTable {

    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("round")
    @Expose
    private String round;
    @SerializedName("Races")
    @Expose
    private List<Race> races = null;

    /**
     * No args constructor for use in serialization
     */
    public RaceTable() {
    }

    /**
     * @param season
     * @param races
     * @param round
     */
    public RaceTable(String season, String round, List<Race> races) {
        super();
        this.season = season;
        this.round = round;
        this.races = races;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
