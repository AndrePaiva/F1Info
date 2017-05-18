package com.andrepaiva.f1info.data.model.ApiEntities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andre on 15/04/2017.
 */

public class DriverStanding {

    @SerializedName("position")
    private String position;

    @SerializedName("positionText")
    private String positionText;

    @SerializedName("points")
    private String points;

    @SerializedName("wins")
    private String wins;

    @SerializedName("Driver")
    private Driver driver;

    @SerializedName("Constructors")
    private List<Constructor> constructors = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public DriverStanding() {
    }

    /**
     *
     * @param position
     * @param driver
     * @param points
     * @param constructors
     * @param positionText
     * @param wins
     */
    public DriverStanding(String position, String positionText, String points, String wins, Driver driver, List<Constructor> constructors) {
        super();
        this.position = position;
        this.positionText = positionText;
        this.points = points;
        this.wins = wins;
        this.driver = driver;
        this.constructors = constructors;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Constructor> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
    }
}
