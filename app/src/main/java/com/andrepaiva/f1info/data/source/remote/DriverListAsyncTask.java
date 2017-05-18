package com.andrepaiva.f1info.data.source.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;
import com.andrepaiva.f1info.data.model.ApiEntities.Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class DriverListAsyncTask extends AsyncTask<Object, Object, List<Driver>> {

    private final Callback callback;

    public DriverListAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        callback.onPreExecute();
    }

    @Override
    protected List<Driver> doInBackground(Object... params) {
        List<Driver> model = new ArrayList<>();

        try {
            Response<ApiResponse> driverListResponse = APIHelper.instance().getF1ApiClient().getDriverList().execute();
            if (driverListResponse.isSuccessful()) {
                return driverListResponse.body().getMRData().getDriverTable().getDrivers();
            }
        } catch (IOException e) {
            callback.onError(e);
            Log.e("F1", "Error requesting data" + e.getMessage(), e);
        }

        return model;
    }

    @Override
    protected void onPostExecute(List<Driver> model) {
        callback.onPostExecute(model);
    }

    public interface Callback {

        void onPreExecute();

        void onPostExecute(List<Driver> model);

        void onError(Throwable throwable);
    }
}