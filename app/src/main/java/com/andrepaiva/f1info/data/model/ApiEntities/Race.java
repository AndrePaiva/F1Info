package com.andrepaiva.f1info.data.model.ApiEntities;

/**
 * Created by andre on 15/04/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Race {

    @SerializedName("season")
    private String season;

    @SerializedName("round")
    private String round;

    @SerializedName("url")
    private String url;

    @SerializedName("raceName")
    private String raceName;

    @SerializedName("Circuit")
    private Circuit circuit;

    @SerializedName("date")
    private String date;

    @SerializedName("time")
    private String time;

    @SerializedName("Results")
    private List<Result> results;

    @SerializedName("QualifyingResults")
    private List<QualifyingResult> qualifyingResults;

    /**
     * No args constructor for use in serialization
     */
    public Race() {
    }

    /**
     * @param time
     * @param results
     * @param season
     * @param raceName
     * @param circuit
     * @param round
     * @param date
     * @param url
     */
    public Race(String season, String round, String url, String raceName, Circuit circuit,
                String date, String time, List<Result> results, List<QualifyingResult> qualifyingResults) {
        super();
        this.season = season;
        this.round = round;
        this.url = url;
        this.raceName = raceName;
        this.circuit = circuit;
        this.date = date;
        this.time = time;
        this.results = results;
        this.qualifyingResults = qualifyingResults;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<QualifyingResult> getQualifyingResults() {
        return qualifyingResults;
    }

    public void setQualifyingResults(List<QualifyingResult> qualifyingResults) {
        this.qualifyingResults = qualifyingResults;
    }
}
