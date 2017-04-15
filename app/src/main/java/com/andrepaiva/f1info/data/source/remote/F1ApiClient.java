package com.andrepaiva.f1info.data.source.remote;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface F1ApiClient {

    @GET("/last/results.json")
    Call<ApiResponse> getLastResults();
}
