package com.andrepaiva.f1info.data.model.ApiEntities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StandingsList {

    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("round")
    @Expose
    private String round;
    @SerializedName("DriverStandings")
    @Expose
    private List<DriverStanding> driverStandings = null;

    /**
     * No args constructor for use in serialization
     */
    public StandingsList() {
    }

    /**
     * @param season
     * @param driverStandings
     * @param round
     */
    public StandingsList(String season, String round, List<DriverStanding> driverStandings) {
        super();
        this.season = season;
        this.round = round;
        this.driverStandings = driverStandings;
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

    public List<DriverStanding> getDriverStandings() {
        return driverStandings;
    }

    public void setDriverStandings(List<DriverStanding> driverStandings) {
        this.driverStandings = driverStandings;
    }
}
