package com.andrepaiva.f1info.data.source.remote;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface F1ApiClient {

    @GET("current/last/results.json")
    Call<ApiResponse> getLastResults();

    @GET("current/driverStandings.json")
    Call<ApiResponse> getDriverStandings();

    @GET("current/next.json")
    Call<ApiResponse> getNextRace();

    @GET("current/constructorStandings.json")
    Call<ApiResponse> getConstructorStandings();

    @GET("current/last/qualifying.json")
    Call<ApiResponse> getQualifying();

    @GET("current/drivers.json")
    Call<ApiResponse> getDriverList();

    @GET("current/constructors.json")
    Call<ApiResponse> getConstructorList();

    @GET("current.json")
    Call<ApiResponse> getRacesSchedule();
}
