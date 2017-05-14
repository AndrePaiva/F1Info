package com.andrepaiva.f1info.data.source.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;
import com.andrepaiva.f1info.data.model.DashboardResponse;

import java.io.IOException;

import retrofit2.Response;

public class DriverStandingAsyncTask extends AsyncTask<Object, Object, DashboardResponse> {

    private final Callback callback;

    public DriverStandingAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        callback.onPreExecute();
    }

    @Override
    protected DashboardResponse doInBackground(Object... params) {
        DashboardResponse model = new DashboardResponse();

        try {
            Response<ApiResponse> driverStandingResponse = APIHelper.instance().getF1ApiClient().getDriverStandings().execute();
            if (driverStandingResponse.isSuccessful()) {
                model.setLastResults(driverStandingResponse.body());
            }
        } catch (IOException e) {
            callback.onError(e);
            Log.e("F1", "Error requesting data" + e.getMessage(), e);
        }

        return model;
    }

    @Override
    protected void onPostExecute(DashboardResponse model) {
        callback.onPostExecute(model);
    }

    public interface Callback {

        void onPreExecute();

        void onPostExecute(DashboardResponse model);

        void onError(Throwable throwable);
    }
}