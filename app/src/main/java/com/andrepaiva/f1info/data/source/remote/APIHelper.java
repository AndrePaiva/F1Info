package com.andrepaiva.f1info.data.source.remote;


import android.util.Log;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andre on 15/04/2017.
 */

public class APIHelper {

    private static final String BASE_URL = "http://ergast.com/api/f1/";

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
                .client(getOkHttpClient())
                .build();
    }

    public F1ApiClient getF1ApiClient() {
        if (f1ApiClient == null) {
            f1ApiClient = retrofit.create(F1ApiClient.class);
        }

        return f1ApiClient;
    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(5, TimeUnit.SECONDS);
        httpClient.readTimeout(5, TimeUnit.SECONDS);
        httpClient.retryOnConnectionFailure(true);
        httpClient.addInterceptor(new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = null;

                int tryCount = 0;
                while ((response == null || !response.isSuccessful()) && tryCount < 3) {
                    tryCount++;

                    try {
                        response = chain.proceed(request);
                    } catch (SocketTimeoutException | UnknownHostException e) {
                        Log.e("API", "Error requesting data", e);
                    }

                    Log.i("API", "=========> Retry: " + tryCount + ", URL: " + request.url());
                }

                if (response != null) {
                    return response;
                }

                return new Response.Builder()
                        .code(500)
                        .request(request)
                        .protocol(Protocol.HTTP_1_1)
                        .body(new ResponseBody() {
                            @Override
                            public MediaType contentType() {
                                return MediaType.parse("application/json");
                            }

                            @Override
                            public long contentLength() {
                                return 0;
                            }

                            @Override
                            public BufferedSource source() {
                                return new Buffer();
                            }
                        })
                        .build();
            }
        });

        return httpClient.build();
    }
}