package com.andrepaiva.f1info.data.source.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;
import com.andrepaiva.f1info.data.model.ApiEntities.Race;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class CalendarAsyncTask extends AsyncTask<Object, Object, List<Race>> {

    private final String RACE_SCHEDULE_URL = "http://ergast.com/api/f1/current.json/";

    private final Callback callback;

    public CalendarAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        callback.onPreExecute();
    }

    @Override
    protected List<Race> doInBackground(Object... params) {
        List<Race> model = new ArrayList<>();

        try {
            Response<ApiResponse> calendarResponse = APIHelper.instance().getF1ApiClient().getRacesSchedule().execute();
            if (calendarResponse.isSuccessful()) {
                return calendarResponse.body().getMRData().getRaceTable().getRaces();
            }
        } catch (IOException e) {
            callback.onError(e);
            Log.e("F1", "Error requesting data" + e.getMessage(), e);
        }

        return model;
    }

    @Override
    protected void onPostExecute(List<Race> model) {
        callback.onPostExecute(model);
    }

    public interface Callback {

        void onPreExecute();

        void onPostExecute(List<Race> model);

        void onError(Throwable throwable);
    }
}