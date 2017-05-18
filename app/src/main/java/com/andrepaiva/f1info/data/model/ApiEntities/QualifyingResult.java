package com.andrepaiva.f1info.data.model.ApiEntities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andre on 17/05/2017.
 */

public class QualifyingResult {
    @SerializedName("number")
    private String number;

    @SerializedName("position")
    private String position;

    @SerializedName("Driver")
    private Driver driver;

    @SerializedName("Constructor")
    private Constructor constructor;

    @SerializedName("Q1")
    private String q1;

    @SerializedName("Q2")
    private String q2;

    @SerializedName("Q3")
    private String q3;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public QualifyingResult withNumber(String number) {
        this.number = number;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public QualifyingResult withPosition(String position) {
        this.position = position;
        return this;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public QualifyingResult withDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public QualifyingResult withConstructor(Constructor constructor) {
        this.constructor = constructor;
        return this;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public QualifyingResult withQ1(String q1) {
        this.q1 = q1;
        return this;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public QualifyingResult withQ2(String q2) {
        this.q2 = q2;
        return this;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public QualifyingResult withQ3(String q3) {
        this.q3 = q3;
        return this;
    }

}
