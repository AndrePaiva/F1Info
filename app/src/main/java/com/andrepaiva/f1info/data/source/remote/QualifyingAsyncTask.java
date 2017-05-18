package com.andrepaiva.f1info.data.source.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;
import com.andrepaiva.f1info.data.model.ApiEntities.QualifyingResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class QualifyingAsyncTask extends AsyncTask<Object, Object, List<QualifyingResult>> {

    private final Callback callback;

    public QualifyingAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        callback.onPreExecute();
    }

    @Override
    protected List<QualifyingResult> doInBackground(Object... params) {
        List<QualifyingResult> model = new ArrayList<>();

        try {
            Response<ApiResponse> qualifyingResponse = APIHelper.instance().getF1ApiClient().getQualifying().execute();
            if (qualifyingResponse.isSuccessful()) {
                return qualifyingResponse.body().getMRData().getRaceTable().getRaces().get(0).getQualifyingResults();
            }
        } catch (IOException e) {
            callback.onError(e);
            Log.e("F1", "Error requesting data" + e.getMessage(), e);
        }

        return model;
    }

    @Override
    protected void onPostExecute(List<QualifyingResult> model) {
        callback.onPostExecute(model);
    }

    public interface Callback {

        void onPreExecute();

        void onPostExecute(List<QualifyingResult> model);

        void onError(Throwable throwable);
    }
}