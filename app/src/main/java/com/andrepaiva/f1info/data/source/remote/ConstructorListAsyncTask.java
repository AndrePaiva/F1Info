package com.andrepaiva.f1info.data.source.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;
import com.andrepaiva.f1info.data.model.ApiEntities.Constructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class ConstructorListAsyncTask extends AsyncTask<Object, Object, List<Constructor>> {

    private final Callback callback;

    public ConstructorListAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        callback.onPreExecute();
    }

    @Override
    protected List<Constructor> doInBackground(Object... params) {
        List<Constructor> model = new ArrayList<>();

        try {
            Response<ApiResponse> constructorListResponse = APIHelper.instance().getF1ApiClient().getConstructorList().execute();
            if (constructorListResponse.isSuccessful()) {
                return constructorListResponse.body().getMRData().getConstructorTable().getConstructors();
            }
        } catch (IOException e) {
            callback.onError(e);
            Log.e("F1", "Error requesting data" + e.getMessage(), e);
        }

        return model;
    }

    @Override
    protected void onPostExecute(List<Constructor> model) {
        callback.onPostExecute(model);
    }

    public interface Callback {

        void onPreExecute();

        void onPostExecute(List<Constructor> model);

        void onError(Throwable throwable);
    }
}