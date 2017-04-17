package com.andrepaiva.f1info.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.DashboardResponse;
import com.andrepaiva.f1info.data.source.remote.DashboardAsyncTask;
import com.google.gson.Gson;

public class DashboardFragment extends Fragment {

    private static final String TAG = DashboardFragment.class.getSimpleName();

    private DashboardAsyncTask task;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dashboard, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("F1 Info");

        task = new DashboardAsyncTask(new DashboardAsyncTask.Callback() {

            @Override
            public void onPreExecute() {
                Log.d(TAG, "On Post Execute Call Succeeded");
            }

            @Override
            public void onPostExecute(DashboardResponse model) {
                Log.d(TAG, "On Post Execute Call Succeeded");

                Gson gson = new Gson();
                Log.d(TAG, "Teste 1: " + (gson.toJson(model.getLastResults())));
                Log.d(TAG, "Teste 2: " + (gson.toJson(model.getDriverStandings())));
                Log.d(TAG, "Teste 3: " + (gson.toJson(model.getNextRace())));
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "Last Results Call Failed");
            }
        });
        task.execute();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (task != null && task.getStatus() != AsyncTask.Status.FINISHED) {
            task.cancel(true);
        }
    }
}