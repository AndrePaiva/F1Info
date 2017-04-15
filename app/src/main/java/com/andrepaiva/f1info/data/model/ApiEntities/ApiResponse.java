package com.andrepaiva.f1info.data.model.ApiEntities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("MRData")
    @Expose
    private MRData mRData;

    /**
     * No args constructor for use in serialization
     *
     */
    public ApiResponse() {
    }

    /**
     *
     * @param mRData
     */
    public ApiResponse(MRData mRData) {
        super();
        this.mRData = mRData;
    }

    public MRData getMRData() {
        return mRData;
    }

    public void setMRData(MRData mRData) {
        this.mRData = mRData;
    }
}
