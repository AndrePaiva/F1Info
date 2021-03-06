package com.andrepaiva.f1info.data.model.ApiEntities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Driver {

    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("permanentNumber")
    @Expose
    private String permanentNumber;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("givenName")
    @Expose
    private String givenName;
    @SerializedName("familyName")
    @Expose
    private String familyName;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("nationality")
    @Expose
    private String nationality;

    /**
     * No args constructor for use in serialization
     *
     */
    public Driver() {
    }

    /**
     *
     * @param dateOfBirth
     * @param nationality
     * @param driverId
     * @param familyName
     * @param givenName
     * @param code
     * @param url
     * @param permanentNumber
     */
    public Driver(String driverId, String permanentNumber, String code, String url, String givenName, String familyName, String dateOfBirth, String nationality) {
        super();
        this.driverId = driverId;
        this.permanentNumber = permanentNumber;
        this.code = code;
        this.url = url;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPermanentNumber() {
        return permanentNumber;
    }

    public void setPermanentNumber(String permanentNumber) {
        this.permanentNumber = permanentNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
