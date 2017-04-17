package com.andrepaiva.f1info.data.source.remote;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andre on 15/04/2017.
 */

public class APIHelper {

    private static final String BASE_URL = "http://ergast.com/api/f1/2017/";

    private static APIHelper helper;

    private F1ApiClient f1ApiClient;
    private Retrofit retrofit;

    public static APIHelper instance() {
        if (helper == null) {
            helper = new APIHelper();
        }

        return helper;
    }

    private APIHelper() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public F1ApiClient getF1ApiClient() {
        if (f1ApiClient == null) {
            f1ApiClient = retrofit.create(F1ApiClient.class);
        }

        return f1ApiClient;
    }
}