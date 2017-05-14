package com.andrepaiva.f1info.data.model.ApiEntities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StandingsList {

    @SerializedName("season")
    private String season;

    @SerializedName("round")
    private String round;

    @SerializedName("DriverStandings")
    private List<DriverStanding> driverStandings;

    @SerializedName("ConstructorStandings")
    private List<ConstructorStanding> constructorStandings;

    /**
     * No args constructor for use in serialization
     */
    public StandingsList() {
    }

    /**
     * @param season
     * @param driverStandings
     * @param round
     * @param constructorStandings
     */
    public StandingsList(String season, String round, List<DriverStanding> driverStandings, List<ConstructorStanding> constructorStandings) {
        super();
        this.season = season;
        this.round = round;
        this.driverStandings = driverStandings;
        this.constructorStandings = constructorStandings;
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

    public List<ConstructorStanding> getConstructorStandings() {
        return constructorStandings;
    }

    public void setConstructorStandings(List<ConstructorStanding> constructorStandings) {
        this.constructorStandings = constructorStandings;
    }
}
