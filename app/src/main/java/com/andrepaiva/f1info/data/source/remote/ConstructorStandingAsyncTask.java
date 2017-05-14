package com.andrepaiva.f1info.data.source.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;
import com.andrepaiva.f1info.data.model.ApiEntities.ConstructorStanding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class ConstructorStandingAsyncTask extends AsyncTask<Object, Object, List<ConstructorStanding>> {

    private final Callback callback;

    public ConstructorStandingAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        callback.onPreExecute();
    }

    @Override
    protected List<ConstructorStanding> doInBackground(Object... params) {
        List<ConstructorStanding> model = new ArrayList<>();

        try {
            Response<ApiResponse> constructorStandingResponse = APIHelper.instance().getF1ApiClient().getConstructorStandings().execute();
            if (constructorStandingResponse.isSuccessful()) {
                return constructorStandingResponse.body().getMRData().getStandingsTable().getStandingsLists()
                        .get(0).getConstructorStandings();
            }
        } catch (IOException e) {
            callback.onError(e);
            Log.e("F1", "Error requesting data" + e.getMessage(), e);
        }

        return model;
    }

    @Override
    protected void onPostExecute(List<ConstructorStanding> model) {
        callback.onPostExecute(model);
    }

    public interface Callback {

        void onPreExecute();

        void onPostExecute(List<ConstructorStanding> model);

        void onError(Throwable throwable);
    }
}