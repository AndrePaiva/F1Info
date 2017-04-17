package com.andrepaiva.f1info.data.model;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;

/**
 * Created by andre on 17/04/2017.
 */

public class DashboardResponse {

    private ApiResponse lastResults;

    private ApiResponse driverStandings;

    private ApiResponse nextRace;

    public ApiResponse getLastResults() {
        return lastResults;
    }

    public void setLastResults(ApiResponse lastResults) {
        this.lastResults = lastResults;
    }

    public ApiResponse getDriverStandings() {
        return driverStandings;
    }

    public void setDriverStandings(ApiResponse driverStandings) {
        this.driverStandings = driverStandings;
    }

    public ApiResponse getNextRace() {
        return nextRace;
    }

    public void setNextRace(ApiResponse nextRace) {
        this.nextRace = nextRace;
    }
}
