package com.andrepaiva.f1info.data.source.remote;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface F1ApiClient {

    @GET("last/results.json")
    Call<ApiResponse> getLastResults();

    @GET("driverStandings.json")
    Call<ApiResponse> getDriverStandings();

    @GET("next.json")
    Call<ApiResponse> getNextRace();

    @GET("constructorStandings.json")
    Call<ApiResponse> getConstructorStandings();

    @GET("last/qualifying.json")
    Call<ApiResponse> getQualifying();

    @GET("drivers.json")
    Call<ApiResponse> getDriverList();
}
