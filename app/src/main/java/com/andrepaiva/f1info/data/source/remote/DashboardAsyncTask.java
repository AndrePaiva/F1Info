package com.andrepaiva.f1info.data.source.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.andrepaiva.f1info.data.model.DashboardResponse;
import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;

import java.io.IOException;

import retrofit2.Response;

public class DashboardAsyncTask extends AsyncTask<Object, Object, DashboardResponse> {

    private final Callback callback;

    public DashboardAsyncTask(Callback callback) {
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
            Response<ApiResponse> lastResultsResponse = APIHelper.instance().getF1ApiClient().getLastResults().execute();
            if (lastResultsResponse.isSuccessful()) {
                model.setLastResults(lastResultsResponse.body());
            }

            Response<ApiResponse> driverStandingsResponse = APIHelper.instance().getF1ApiClient().getDriverStandings().execute();
            if (driverStandingsResponse.isSuccessful()) {
                model.setDriverStandings(driverStandingsResponse.body());
            }

            Response<ApiResponse> nextRaceResponse = APIHelper.instance().getF1ApiClient().getNextRace().execute();
            if (nextRaceResponse.isSuccessful()) {
                model.setNextRace(nextRaceResponse.body());
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