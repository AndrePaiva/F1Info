package com.andrepaiva.f1info.data.source.remote;

import com.andrepaiva.f1info.constants.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andre on 15/04/2017.
 */

public class APIHelper {

    private static final String BASE_URL = "http://ergast.com/api/f1/2017";

    public static F1ApiClient f1ApiClient;

    public static F1ApiClient getF1ApiClient() {
        if (f1ApiClient == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            f1ApiClient = retrofit.create(F1ApiClient.class);
        }
        return f1ApiClient;
    }
}
