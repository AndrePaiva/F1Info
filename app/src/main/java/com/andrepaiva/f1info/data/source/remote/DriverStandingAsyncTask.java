package com.andrepaiva.f1info.data.source.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;
import com.andrepaiva.f1info.data.model.ApiEntities.DriverStanding;
import com.andrepaiva.f1info.data.model.DashboardResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class DriverStandingAsyncTask extends AsyncTask<Object, Object, List<DriverStanding>> {

    private final Callback callback;

    public DriverStandingAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        callback.onPreExecute();
    }

    @Override
    protected List<DriverStanding> doInBackground(Object... params) {
        List<DriverStanding> model = new ArrayList<>();

        try {
            Response<ApiResponse> driverStandingResponse = APIHelper.instance().getF1ApiClient().getDriverStandings().execute();
            if (driverStandingResponse.isSuccessful()) {
                return driverStandingResponse.body().getMRData().getStandingsTable().getStandingsLists()
                        .get(0).getDriverStandings();
            }
        } catch (IOException e) {
            callback.onError(e);
            Log.e("F1", "Error requesting data" + e.getMessage(), e);
        }

        return model;
    }

    @Override
    protected void onPostExecute(List<DriverStanding> model) {
        callback.onPostExecute(model);
    }

    public interface Callback {

        void onPreExecute();

        void onPostExecute(List<DriverStanding> model);

        void onError(Throwable throwable);
    }
}