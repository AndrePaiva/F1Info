package com.andrepaiva.f1info.data.model.ApiEntities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andre on 27/04/2017.
 */

public class ConstructorStanding {
    @SerializedName("position")
    private String position;

    @SerializedName("positionText")
    private String positionText;

    @SerializedName("points")
    private String points;

    @SerializedName("wins")
    private String wins;

    @SerializedName("Constructor")
    private Constructor constructor;

    /**
     * No args constructor for use in serialization
     *
     */
    public ConstructorStanding() {
    }

    /**
     *
     * @param position
     * @param points
     * @param positionText
     * @param constructor
     * @param wins
     */
    public ConstructorStanding(String position, String positionText, String points, String wins, Constructor constructor) {
        super();
        this.position = position;
        this.positionText = positionText;
        this.points = points;
        this.wins = wins;
        this.constructor = constructor;
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

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }
}
