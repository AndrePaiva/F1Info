package com.andrepaiva.f1info.data.model.ApiEntities;

import com.andrepaiva.f1info.data.model.ApiEntities.tables.DriverTable;
import com.andrepaiva.f1info.data.model.ApiEntities.tables.RaceTable;
import com.andrepaiva.f1info.data.model.ApiEntities.tables.StandingsTable;
import com.google.gson.annotations.SerializedName;

public class MRData {

    @SerializedName("xmlns")
    private String xmlns;

    @SerializedName("series")
    private String series;

    @SerializedName("url")
    private String url;

    @SerializedName("limit")
    private String limit;

    @SerializedName("offset")
    private String offset;

    @SerializedName("total")
    private String total;

    @SerializedName("StandingsTable")
    private StandingsTable standingsTable;

    @SerializedName("RaceTable")
    private RaceTable raceTable;

    @SerializedName("DriverTable")
    private DriverTable driverTable;

    /**
     * No args constructor for use in serialization
     */
    public MRData() {
    }

    /**
     * @param total
     * @param limit
     * @param series
     * @param xmlns
     * @param offset
     * @param url
     * @param standingsTable
     */
    public MRData(String xmlns, String series, String url, String limit, String offset, String total, StandingsTable standingsTable) {
        super();
        this.xmlns = xmlns;
        this.series = series;
        this.url = url;
        this.limit = limit;
        this.offset = offset;
        this.total = total;
        this.standingsTable = standingsTable;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public StandingsTable getStandingsTable() {
        return standingsTable;
    }

    public void setStandingsTable(StandingsTable standingsTable) {
        this.standingsTable = standingsTable;
    }

    public RaceTable getRaceTable() {
        return raceTable;
    }

    public void setRaceTable(RaceTable raceTable) {
        this.raceTable = raceTable;
    }

    public DriverTable getDriverTable() {
        return driverTable;
    }

    public void setDriverTable(DriverTable driverTable) {
        this.driverTable = driverTable;
    }
}